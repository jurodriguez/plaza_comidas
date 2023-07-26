package com.example.user.services.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    NUMBER_DOCUMENT_INCORRECT("The document number is incorrect"),
    USER_IS_NOT_LEGAL_AGE("The user is not of legal age"),
    PHONE_NUMBER_INCORRECT("The number phone structure is incorrect"),
    NO_DATA_FOUND("No data found for the requested petition");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
