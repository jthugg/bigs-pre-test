package org.example.bigs.pretest.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.bigs.pretest.mysql.model.PrecipitationType;
import org.example.bigs.pretest.mysql.model.SkyStatus;

import java.time.Instant;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ForeCast {

    @Id
    private Long id;
    private byte precipitationProbability;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255)")
    private PrecipitationType precipitationType;
    private float amountOfPrecipitation;
    private byte humidity;
    private float amountOfSnow;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255)")
    private SkyStatus skyStatus;
    private Float temperature;
    private Float maxTemperatureOfDay;
    private Float minTemperatureOfDay;
    private float horizontalWindSpeed;
    private float verticalWindSpeed;
    private float waveHeight;
    private short windDirection;
    private float windSpeed;
    private Instant forecastAt; // 예보 시점
    private Instant announcedAt; // 예보 발표 시점

}
