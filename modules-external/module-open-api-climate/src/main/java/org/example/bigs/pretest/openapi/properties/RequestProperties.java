package org.example.bigs.pretest.openapi.properties;

import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

@Getter
public class RequestProperties {

    public static final String SERVICE_KEY = "serviceKey";
    public static final String PAGE = "page";
    public static final String NUM_OF_ROWS = "numOfRows";
    public static final String DATA_TYPE = "dataType";
    public static final String BASE_DATE = "base_date";
    public static final String BASE_TIME = "base_time";
    public static final String COORDINATE_X = "ny";
    public static final String COORDINATE_Y = "nx";

    private final String uri;
    private final String serviceKey;
    private final int page;
    private final int numOfRows;
    private final int base_date;
    private final int base_time;
    private final String dataType;
    private final String coordinateX;
    private final String coordinateY;

    public RequestProperties(
            String uri,
            String serviceKey,
            int page,
            int numOfRows,
            String dataType,
            String coordinateX,
            String coordinateY
    ) {
        this.uri = uri;
        this.serviceKey = serviceKey;
        this.page = page;
        this.numOfRows = numOfRows;
        this.dataType = dataType;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).minusMinutes(10);
        base_date = now.getYear() * 10000 + now.getMonthValue() * 100 + now.getDayOfMonth();;
        base_time = 300 * ((now.getHour() * 100 + now.getMinute()) / 300) - 100;
    }

    public Map<String, Object> toMap() {
        return Map.of(
                SERVICE_KEY, serviceKey,
                PAGE, page,
                NUM_OF_ROWS, numOfRows,
                BASE_DATE, base_date,
                BASE_TIME, base_time,
                DATA_TYPE, dataType,
                COORDINATE_X, coordinateX,
                COORDINATE_Y, coordinateY
        );
    }

}
