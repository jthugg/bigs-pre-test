package org.example.bigs.pretest.presentation;

import lombok.RequiredArgsConstructor;
import org.example.bigs.pretest.application.model.SearchForecastRequest;
import org.example.bigs.pretest.application.service.ForecastService;
import org.example.bigs.pretest.core.util.annotation.Bind;
import org.example.bigs.pretest.core.util.model.Response;
import org.example.bigs.pretest.mysql.entity.ForeCast;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ForecastController {

    private final ForecastService forecastService;

    /**
     * <h1>단기예보 정보 조회 API</h1>
     *
     * 별도 Dto 없이 엔티티 모델 반환으로 응답 자료형 ?로 와일드카드 선언.
     * Dto 추가시 명확한 응답 자료형 명시
     *
     * @see Bind
     * @see SearchForecastRequest
     * @see Response
     * @param request 예보 정보 검색 요청 모델
     * @return Response<?>
     */
    @GetMapping("/forecast")
    public ResponseEntity<Response<?>> getForecast(@Bind SearchForecastRequest request) {
        List<ForeCast> results = forecastService.searchForecasts(request);
        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Response.voidOf());
        }
        return ResponseEntity.status(HttpStatus.OK).body(Response.of(results));
    }

}
