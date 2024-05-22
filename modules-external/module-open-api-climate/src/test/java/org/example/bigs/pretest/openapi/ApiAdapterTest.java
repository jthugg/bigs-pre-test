package org.example.bigs.pretest.openapi;

import org.example.bigs.pretest.openapi.adapter.ClimateForecastAdapter;
import org.example.bigs.pretest.openapi.model.ClimateForecast;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiAdapterTest {

    @Autowired
    ClimateForecastAdapter adapter;

    @Test
    void adapterTest() {
        ClimateForecast data = adapter.getRecentClimateForecast();
        System.out.println(data);
    }

}
