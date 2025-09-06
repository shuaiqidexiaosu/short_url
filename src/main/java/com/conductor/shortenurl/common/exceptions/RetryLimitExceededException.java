package com.conductor.shortenurl.common.exceptions;

public class RetryLimitExceededException extends RuntimeException {
    public RetryLimitExceededException(String message) {
        super(message);
    }
}
