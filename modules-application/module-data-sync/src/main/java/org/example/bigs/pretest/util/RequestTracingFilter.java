package org.example.bigs.pretest.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.example.bigs.pretest.core.util.util.RequestIdContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class RequestTracingFilter extends GenericFilter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        try {
            RequestIdContextHolder.setRequestId(UUID.randomUUID().toString());
            chain.doFilter(request, response);
        } finally {
            RequestIdContextHolder.clearRequestId();
        }
    }

}
