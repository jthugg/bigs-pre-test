package org.example.bigs.pretest.mysql.test.unit;

import lombok.extern.slf4j.Slf4j;
import org.example.bigs.pretest.mysql.repository.ForecastRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

//@Disabled
@Slf4j
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ForecastRepositoryTest {

    @Autowired
    ForecastRepository forecastRepository;

    @Test
    @DisplayName("데이터베이스_컨테이너_헬스체크")
    void healthCheck() throws InterruptedException {
        log.info("{}", forecastRepository.existsById(0L));
        Thread.sleep(60_000);
    }

}
