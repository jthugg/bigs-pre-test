package org.example.bigs.pretest.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.bigs.pretest.application.service.ForecastService;
import org.example.bigs.pretest.core.util.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataFetchController {

    private final ForecastService forecastService;

    @PostMapping("/forecasts")
    public ResponseEntity<Response<Void>> fetchRecentData() {
        forecastService.fetchRecentData();
        return ResponseEntity.status(HttpStatus.OK).body(Response.voidOf());
    }

}
