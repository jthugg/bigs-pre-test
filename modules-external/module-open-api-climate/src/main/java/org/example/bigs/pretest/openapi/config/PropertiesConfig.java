package org.example.bigs.pretest.openapi.config;

import org.example.bigs.pretest.openapi.properties.RequestProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {

    @Bean
    public RequestProperties properties(
            @Value("${open-api.climate.uri}") String uri,
            @Value("${open-api.climate.serviceKey}") String serviceKey,
            @Value("${open-api.climate.page}") int page,
            @Value("${open-api.climate.numOfRows}") int numOfRows,
            @Value("${open-api.climate.dataType}") String dataType,
            @Value("${open-api.climate.coordinateX}") String coordinateX,
            @Value("${open-api.climate.coordinateY}") String coordinateY
    ) {
        return new RequestProperties(uri, serviceKey, page, numOfRows, dataType, coordinateX, coordinateY);
    }

}
