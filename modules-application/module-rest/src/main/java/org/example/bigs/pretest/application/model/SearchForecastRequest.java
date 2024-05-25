package org.example.bigs.pretest.application.model;

import java.time.Instant;

/**
 * <h3>단기 예보 검색 파라미터 모델</h3>
 *
 * if) 정보가 다음과 같다면<br />
 * <pre>{@code
 * announcedAt: 2020-01-01 00:00:00
 * baseAt: 2020-01-02 13:00:00
 * dayRange: 1
 * }</pre>
 * 2020년 1월 2일 13시 부터 1일간의 데이터 중
 * 2020년 1월 1일 00시에 발표된 자료를 가져온다.
 *
 * @param announcedAt 예보 발표 시점 - Default: 현재 시각과 가장 가까운 예보 발표 시점
 * @param baseAt 찾아 볼 예보 기준 시점 - Default: 현재 시각 정각
 * @param dayRange 일 단위 예보 범위 - Default: 1
 */
public record SearchForecastRequest(
        Instant announcedAt, // 예보 발표 시점
        Instant baseAt, // 찾아 볼 예보 기준 시점
        int dayRange // 일 단위 예보 범위
) {}
