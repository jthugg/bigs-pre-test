package org.example.bigs.pretest.application.model;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@ToString
public class TemporalForecastData {

    private byte precipitationProbability;
    private byte precipitationType;
    private String amountOfPrecipitation;
    private byte humidity;
    private String amountOfSnow;
    private byte skyStatus;
    private float temperature;
    private Float maxTemperatureOfDay;
    private Float minTemperatureOfDay;
    private float horizontalWindSpeed;
    private float verticalWindSpeed;
    private float waveHeight;
    private short windDirection;
    private float windSpeed;

    // TZ UTC
    private final Instant announcedAt;
    private final Instant forecastAt;

    private final Lock lock;

    public TemporalForecastData(Instant announcedAt, Instant forecastAt) {
        this.lock = new ReentrantLock();
        this.announcedAt = announcedAt;
        this.forecastAt = forecastAt;
    }

    // disable get lock directly from the others
    private Lock getLock() {
        throw new UnsupportedOperationException();
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public void setData(ForecastDataType type, String value) {
        switch (type) {
            case POP -> this.precipitationProbability = Byte.parseByte(value);
            case PTY -> this.precipitationType = Byte.parseByte(value);
            case PCP -> this.amountOfPrecipitation = value;
            case REH -> this.humidity = Byte.parseByte(value);
            case SNO -> this.amountOfSnow = value;
            case SKY -> this.skyStatus = Byte.parseByte(value);
            case TMP -> this.temperature = Float.parseFloat(value);
            case TMN -> this.maxTemperatureOfDay = Float.parseFloat(value);
            case TMX -> this.minTemperatureOfDay = Float.parseFloat(value);
            case UUU -> this.horizontalWindSpeed = Float.parseFloat(value);
            case VVV -> this.verticalWindSpeed = Float.parseFloat(value);
            case WAV -> this.waveHeight = Float.parseFloat(value);
            case VEC -> this.windDirection = Short.parseShort(value);
            case WSD -> this.windSpeed = Float.parseFloat(value);
        }
    }

}
