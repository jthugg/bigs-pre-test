package org.example.bigs.pretest.openapi.model;

public record Item(
        int baseDate,
        int baseTime,
        int fcstDate,
        int fcstTime,
        String category,
        String fcstValue,
        String nx,
        String ny
) {}
