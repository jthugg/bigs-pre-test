package org.example.bigs.pretest.openapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    OK("00"),
    APPLICATION_ERROR("01"),
    DB_ERROR("02"),
    NO_DATA_ERROR("03"),
    HTTP_ERROR("04"),
    SERVICE_TIME_OUT("05"),
    INVALID_REQUEST_PARAMETER_ERROR("10"),
    NO_MANDATORY_REQUEST_PARAMETERS_ERROR("11"),
    NO_OPEN_API_SERVICE_ERROR("12"),
    SERVICE_ACCESS_DENIED_ERROR("20"),
    TEMPORARILY_DISABLE_THE_SERVICE_KEY_ERROR("21"),
    LIMITED_NUMBER_OF_SERVICE_REQUESTS_EXCEEDS_ERROR("22"),
    SERVICE_KEY_IS_NOT_REGISTERED_ERROR("30"),
    DEADLINE_HAS_EXPIRED_ERROR("31"),
    UNREGISTERED_IP_ERROR("32"),
    UNSIGNED_CALL_ERROR("33"),
    UNKNOWN_ERROR("99"),
    ;

    private final String code;

}
