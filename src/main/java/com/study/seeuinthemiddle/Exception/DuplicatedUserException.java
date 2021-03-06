package com.study.seeuinthemiddle.Exception;

public class DuplicatedUserException extends RuntimeException {

    public DuplicatedUserException() {
    }

    public DuplicatedUserException(String message) {
        super(message);
    }

    public DuplicatedUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedUserException(Throwable cause) {
        super(cause);
    }

    public DuplicatedUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
