package org.example.bigs.pretest.util;

import org.example.bigs.pretest.application.model.SearchForecastRequest;
import org.example.bigs.pretest.core.util.annotation.Bind;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

@Component
public class SearchForecastRequestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Bind.class)
                && parameter.getParameterType().equals(SearchForecastRequest.class);
    }

    @Override
    public SearchForecastRequest resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {
        return new SearchForecastRequest(
                parseInstant(webRequest.getParameter("announcedAt")),
                parseInstant(webRequest.getParameter("baseAt")),
                getDayRange(webRequest.getParameter("dayRange"))
        );
    }

    private Instant parseInstant(String value) {
        try {
            return Instant.parse(value);
        } catch (DateTimeParseException | NullPointerException exception) {
            return getDefaultInstant();
        }
    }

    private Instant getDefaultInstant() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        ZonedDateTime time = ZonedDateTime.of(
                now.getYear(),
                now.getMonthValue(),
                now.getDayOfMonth(),
                Math.max(0, 3 * (now.getHour() / 3) - 1),
                0,
                0,
                0,
                ZoneId.of("Asia/Seoul")
        );
        return time.toInstant();
    }

    private int getDayRange(String value) {
        try {
            if (value == null) {
                return 1;
            }
            int range = Integer.parseInt(value);
            if (range < 1 || range > 72) {
                return 1;
            }
            return range;
        } catch (NumberFormatException exception) {
            return 1;
        }
    }

}
