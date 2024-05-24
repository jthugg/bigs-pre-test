package org.example.bigs.pretest.openapi.model;

public record Item(
        long baseDate,
        long baseTime,
        long fcstDate,
        long fcstTime,
        String category,
        String fcstValue,
        String nx,
        String ny
) {}
