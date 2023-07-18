package com.example.plaza_comidas.domain.exception;

public class RequestException extends RuntimeException {
    private final String code;
    private final String description;

    public RequestException(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public RequestException(String message, String code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public RequestException(String message, Throwable cause, String code, String description) {
        super(message, cause);
        this.code = code;
        this.description = description;
    }

    public RequestException(Throwable cause, String code, String description) {
        super(cause);
        this.code = code;
        this.description = description;
    }

    public RequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String description) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
