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
    
    public static PrecipitationType fromOrdinal(int ordinal) {
        return switch (ordinal) {
            case 0 -> NO;
            case 1 -> RAIN;
            case 2 -> RAIN_SNOW;
            case 3 -> SNOW;
            case 4 -> SHOWER;
            default -> throw new IllegalStateException("Unexpected value: " + ordinal);
        };
    }

}
