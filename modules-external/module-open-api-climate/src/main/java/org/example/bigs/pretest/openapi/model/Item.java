package org.example.bigs.pretest.openapi.model;

public record Item(
        String baseDate,
        String baseTime,
        String fcstDate,
        String fcstTime,
        String category,
        String fcstValue,
        String nx,
        String ny
) {}
