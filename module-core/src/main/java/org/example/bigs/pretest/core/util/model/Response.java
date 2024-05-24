package org.example.bigs.pretest.core.util.model;

import lombok.Getter;
import org.example.bigs.pretest.core.util.util.RequestIdContextHolder;

import java.time.Instant;

@Getter
public class Response<T> {

    private final String requestId;
    private final Instant timestamp;
    private final T content;

    protected Response(T content) {
        this.requestId = RequestIdContextHolder.getRequestId();
        this.timestamp = Instant.now();
        this.content = content;
    }

    public static <T> Response<T> of(T content) {
        return new Response<>(content);
    }

    public static <T> Response<T> voidOf() {
        return new Response<>(null);
    }

}
