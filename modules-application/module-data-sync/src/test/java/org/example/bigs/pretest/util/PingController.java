package org.example.bigs.pretest.util;

import lombok.extern.slf4j.Slf4j;
import org.example.bigs.pretest.core.util.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PingController {

    @GetMapping("/ping")
    public ResponseEntity<Response<String>> pong() {
        log.info("ping!");
        return ResponseEntity.ok(Response.of("pong"));
    }

}
