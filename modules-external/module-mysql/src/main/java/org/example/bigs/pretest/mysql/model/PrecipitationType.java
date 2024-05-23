package org.example.bigs.pretest.mysql.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PrecipitationType {

    NO(0),
    RAIN(1),
    RAIN_SNOW(2),
    SNOW(3),
    SHOWER(4),
    ;

    private final int value;

}
