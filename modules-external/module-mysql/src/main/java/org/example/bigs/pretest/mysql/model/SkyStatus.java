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

}
