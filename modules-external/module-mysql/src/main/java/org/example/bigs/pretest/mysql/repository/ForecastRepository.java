package org.example.bigs.pretest.mysql.repository;

import org.example.bigs.pretest.mysql.entity.ForeCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ForecastRepository extends JpaRepository<ForeCast, Long> {

    boolean existsByAnnouncedAt(Instant announcedAt);
    List<ForeCast> findByAnnouncedAtAndForecastAtBetweenOrderByForecastAtDesc(Instant announcedAt, Instant begin, Instant end);

}
