package org.example.bigs.pretest.application.service;

import org.example.bigs.pretest.application.model.SearchForecastRequest;
import org.example.bigs.pretest.mysql.entity.ForeCast;

import java.util.List;

public interface ForecastService {

    List<ForeCast> searchForecasts(SearchForecastRequest request);

}
