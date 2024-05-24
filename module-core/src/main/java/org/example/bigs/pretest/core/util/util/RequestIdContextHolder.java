package org.example.bigs.pretest.core.util.util;

public class RequestIdContextHolder {

    private static final ThreadLocal<String> requestId = new ThreadLocal<>();

    public static String getRequestId() {
        return requestId.get();
    }

    public static void setRequestId(String requestId) {
        RequestIdContextHolder.requestId.set(requestId);
    }

    public static void clearRequestId() {
        requestId.remove();
    }

}
