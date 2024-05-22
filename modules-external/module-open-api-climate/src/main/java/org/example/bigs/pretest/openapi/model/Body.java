package org.example.bigs.pretest.openapi.model;

public record Body(
        ResponseType dataType,
        Items items,
        int pageNo,
        int numOfRows,
        int totalCount
) {}
