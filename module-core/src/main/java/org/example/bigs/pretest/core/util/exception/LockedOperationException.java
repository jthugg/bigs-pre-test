package org.example.bigs.pretest.core.util.exception;

public class LockedOperationException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "this operation has been locked.";

    public LockedOperationException() {
        super(DEFAULT_MESSAGE);
    }

    public LockedOperationException(String message) {
        super(message);
    }

}
