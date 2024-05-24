package org.example.bigs.pretest.application.service;

import lombok.RequiredArgsConstructor;
import org.example.bigs.pretest.application.model.ForecastDataType;
import org.example.bigs.pretest.application.model.TemporalForecastData;
import org.example.bigs.pretest.application.model.TemporalForecastDataStorage;
import org.example.bigs.pretest.core.util.annotation.CustomLock;
import org.example.bigs.pretest.exception.DataAlreadyFetchedException;
import org.example.bigs.pretest.mysql.entity.ForeCast;
import org.example.bigs.pretest.mysql.model.PrecipitationType;
import org.example.bigs.pretest.mysql.model.SkyStatus;
import org.example.bigs.pretest.mysql.repository.ForecastRepository;
import org.example.bigs.pretest.openapi.adapter.ClimateForecastAdapter;
import org.example.bigs.pretest.openapi.model.ClimateForecast;
import org.example.bigs.pretest.openapi.model.Item;
import org.example.bigs.pretest.util.ForecastTemporalDataConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleForecastService implements ForecastService {

    private final ForecastRepository forecastRepository;
    private final ClimateForecastAdapter climateForecastAdapter;
    private final TemporalForecastDataStorage temporalForecastDataStorage;

    /**
     * AOP 기반 동시성 처리로 메서드 실행 실패시 즉시 예외 발생
     *
     * @see org.example.bigs.pretest.core.util.exception.LockedOperationException
     * @see org.example.bigs.pretest.core.util.util.ApplicationLockProvider
     * @see org.example.bigs.pretest.util.AopTransactionExecutor
     * @see org.example.bigs.pretest.util.LockAop
     */
    @Override
    @CustomLock
    @Transactional
    public void fetchRecentData() {
        checkDataAlreadyExists();
        ClimateForecast data = climateForecastAdapter.getRecentClimateForecast(); // throws OpenApiException
        getRawData(data).parallelStream()
                .map(this::manufactureRawData)
                .distinct()
                .toList()
                .forEach(this::persistData);
        temporalForecastDataStorage.clear();
    }

    private void checkDataAlreadyExists() {
        if (forecastRepository.existsByAnnouncedAt(ForecastTemporalDataConverter.now())) {
            throw new DataAlreadyFetchedException();
        }
    }

    private List<Item> getRawData(ClimateForecast data) {
        return data.response().body().items().item();
    }

    private TemporalForecastData manufactureRawData(Item value) {
        long baseDateTime = (value.baseDate() * 10_000) + value.baseTime(); // yyy_yMM_ddH_Hmm
        long forecastDateTime = (value.fcstDate() * 10_000) + value.fcstTime(); // yyy_yMM_ddH_Hmm
        TemporalForecastData temporalForecastData = getForecastData(baseDateTime, forecastDateTime);
        setEachData(temporalForecastData, value.category(), value.fcstValue());
        return temporalForecastData;
    }

    private TemporalForecastData getForecastData(long baseDateTime, long forecastDateTime) {
        try {
            temporalForecastDataStorage.lock();
            return temporalForecastDataStorage.getOrCreate(baseDateTime, forecastDateTime);
        } finally {
            temporalForecastDataStorage.unlock();
        }
    }

    private void setEachData(TemporalForecastData data, String dataType, String dataValue) {
        try {
            data.lock();
            data.setData(ForecastDataType.valueOf(dataType), dataValue);
        } finally {
            data.unlock();
        }
    }

    private void persistData(TemporalForecastData data) {
        forecastRepository.save(toEntity(data));
    }

    private ForeCast toEntity(TemporalForecastData data) {
        return ForeCast.builder()
                .precipitationProbability(data.getPrecipitationProbability())
                .precipitationType(PrecipitationType.fromOrdinal(data.getPrecipitationType()))
                .amountOfPrecipitation(data.getAmountOfPrecipitation())
                .humidity(data.getHumidity())
                .amountOfSnow(data.getAmountOfSnow())
                .skyStatus(SkyStatus.fromCode(data.getSkyStatus()))
                .temperature(data.getTemperature())
                .maxTemperatureOfDay(data.getMaxTemperatureOfDay())
                .minTemperatureOfDay(data.getMinTemperatureOfDay())
                .horizontalWindSpeed(data.getHorizontalWindSpeed())
                .verticalWindSpeed(data.getVerticalWindSpeed())
                .waveHeight(data.getWaveHeight())
                .windDirection(data.getWindDirection())
                .windSpeed(data.getWindSpeed())
                .announcedAt(data.getAnnouncedAt())
                .forecastAt(data.getForecastAt())
                .build();
    }

}
