package org.example.bigs.pretest.application.service;

import lombok.RequiredArgsConstructor;
import org.example.bigs.pretest.application.model.SearchForecastRequest;
import org.example.bigs.pretest.mysql.entity.ForeCast;
import org.example.bigs.pretest.mysql.repository.ForecastRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleForecastService implements ForecastService {

    private final ForecastRepository forecastRepository;

    @Override
    public List<ForeCast> searchForecasts(SearchForecastRequest request) {
        long hours = request.dayRange() * 86400L;
        Instant baseTo = request.baseAt().plusSeconds(hours);
        return forecastRepository.findByAnnouncedAtAndForecastAtBetweenOrderByForecastAtDesc(
                request.announcedAt(),
                request.baseAt(),
                baseTo
        );
    }

}
