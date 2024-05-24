package org.example.bigs.pretest.exception;

public class DataAlreadyFetchedException extends DataSyncException {

    public static final String DEFAULT_MESSAGE = "The latest forecast data has already fetched.";

    public DataAlreadyFetchedException() {
        super(DEFAULT_MESSAGE);
    }

    public DataAlreadyFetchedException(String message) {
        super(message);
    }

}
