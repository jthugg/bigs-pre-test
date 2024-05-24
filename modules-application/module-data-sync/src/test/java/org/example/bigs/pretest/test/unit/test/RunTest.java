package org.example.bigs.pretest.test.unit.test;

import org.example.bigs.pretest.application.service.SimpleForecastService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RunTest {

    @Autowired
    private SimpleForecastService forecastService;

    @Test
    void test() {
        forecastService.fetchRecentData();
    }

}
