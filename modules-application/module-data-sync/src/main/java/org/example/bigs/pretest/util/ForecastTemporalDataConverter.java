package org.example.bigs.pretest.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ForecastTemporalDataConverter {

    public static Instant now() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).minusMinutes(10);
        ZonedDateTime time = ZonedDateTime.of(
                now.getYear(),
                now.getMonthValue(),
                now.getDayOfMonth(),
                3 * (now.getHour() / 3) - 1,
                0,
                0,
                0,
                ZoneId.of("Asia/Seoul")
        );
        System.out.println(time);
        return time.toInstant();
    }

    public static Instant from(long dateTime) { // dateTime yyy yMM ddH Hmm
        long year = dateTime / 100_000_000;
        long month = (dateTime % 100_000_000) / 1_000_000;
        long day = (dateTime % 100_000_000 % 1_000_000) / 10_000;
        long hour = (dateTime % 100_000_000 % 1_000_000 % 10_000) / 100;
        return ZonedDateTime.of(
                (int) year,
                (int) month,
                (int) day,
                (int) hour,
                0,
                0,
                0,
                ZoneId.of("Asia/Seoul")
        ).toInstant();
    }

}
