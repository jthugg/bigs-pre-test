package org.example.bigs.pretest.application.model;

import org.example.bigs.pretest.util.ForecastTemporalDataConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class TemporalForecastDataStorage {

    private final Map<String, TemporalForecastData> forecastDatum;
    private final Lock lock;

    public TemporalForecastDataStorage() {
        this.forecastDatum = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    /**
     * 데이터가 없다면 임시저장소에 삽입 후 반환, 데이터가 있다면 그대로 반환.
     *
     * @param baseDateTime open api 예보 발표 시점 yyy_yMM_ddH_Hmm 정수 값
     * @param forecastDateTime 예보 시점 yyy_yMM_ddH_Hmm 정수 값
     * @return ForecastData
     */
    public TemporalForecastData getOrCreate(long baseDateTime, long forecastDateTime) {
        String key = baseDateTime + "-" + forecastDateTime;
        TemporalForecastData temporalForecastData = forecastDatum.get(key);
        if (temporalForecastData == null) {
            temporalForecastData = new TemporalForecastData(
                    ForecastTemporalDataConverter.from(baseDateTime),
                    ForecastTemporalDataConverter.from(forecastDateTime)
            );
            forecastDatum.put(key, temporalForecastData);
        }
        return temporalForecastData;
    }

    public void clear() {
        forecastDatum.clear();
    }

}
