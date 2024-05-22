package org.example.bigs.pretest.openapi.util;

import java.util.Map;

public class QueryParamConverter {

    public static String convert(Map<String, Object> entries) {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Map.Entry<String, Object> entry : entries.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return sb.toString();
    }

}
