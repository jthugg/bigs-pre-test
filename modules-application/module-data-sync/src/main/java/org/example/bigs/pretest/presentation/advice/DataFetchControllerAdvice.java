package org.example.bigs.pretest.presentation.advice;

import org.example.bigs.pretest.core.util.exception.LockedOperationException;
import org.example.bigs.pretest.core.util.model.Response;
import org.example.bigs.pretest.exception.DataSyncException;
import org.example.bigs.pretest.openapi.exception.OpenApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DataFetchControllerAdvice {

    @ExceptionHandler(DataSyncException.class)
    public ResponseEntity<Response<String>> handleDataSyncException(DataSyncException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.of(exception.getMessage()));
    }

    @ExceptionHandler(OpenApiException.class)
    public ResponseEntity<Response<String>> handleOpenApiException(OpenApiException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Response.of(exception.getMessage()));
    }

    @ExceptionHandler(LockedOperationException.class)
    public ResponseEntity<Response<String>> handleLockedOperationException(LockedOperationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.of(exception.getMessage()));
    }

}
