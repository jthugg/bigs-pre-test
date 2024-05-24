package org.example.bigs.pretest.mysql.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SkyStatus {

    SUNNY(1),
    CLOUDY(3),
    OVERCAST(4),
    ;

    private final int value;

    public static SkyStatus fromCode(int value) {
        return switch (value) {
            case 1 -> SUNNY;
            case 3 -> CLOUDY;
            case 4 -> OVERCAST;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }

}
