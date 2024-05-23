package org.example.bigs.pretest.openapi.adapter;

import lombok.RequiredArgsConstructor;
import org.example.bigs.pretest.openapi.exception.OpenApiException;
import org.example.bigs.pretest.openapi.model.ClimateForecast;
import org.example.bigs.pretest.openapi.model.Header;
import org.example.bigs.pretest.openapi.model.ResponseCode;
import org.example.bigs.pretest.openapi.properties.RequestProperties;
import org.example.bigs.pretest.openapi.util.QueryParamConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class ClimateForecastAdapter {

    private final RequestProperties properties;
    private final RestTemplate restTemplate;

    public ClimateForecast getRecentClimateForecast() throws OpenApiException {
        String queryParams = QueryParamConverter.convert(properties.toMap());
        ClimateForecast forecast = restTemplate.getForObject(
                URI.create(properties.getUri() + queryParams),
                ClimateForecast.class
        );
        checkResponse(forecast);
        return forecast;
    }

    private void checkResponse(ClimateForecast forecast) {
        if (forecast == null || forecast.response().header() == null || forecast.response().header().resultCode() == null) {
            throw new OpenApiException();
        }
        Header header = forecast.response().header();
        if (!header.resultCode().equals(ResponseCode.OK.getCode())) {
            throw new OpenApiException("[" + header.resultCode() + "] " + header.resultMsg());
        }
    }

}
