package org.example.bigs.pretest.openapi.adapter;

import lombok.RequiredArgsConstructor;
import org.example.bigs.pretest.openapi.model.ClimateForecast;
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

    public ClimateForecast getRecentClimateForecast() {
        String queryParams = QueryParamConverter.convert(properties.toMap());
        return restTemplate.getForObject(
                URI.create(properties.getUri() + queryParams),
                ClimateForecast.class
        );
    }

}
