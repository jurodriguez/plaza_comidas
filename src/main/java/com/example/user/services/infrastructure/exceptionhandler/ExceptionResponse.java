package com.example.user.services.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    NUMBER_DOCUMENT_INCORRECT("The document number is incorrect"),
    USER_IS_NOT_LEGAL_AGE("The user is not of legal age"),
    PHONE_NUMBER_INCORRECT("The number phone structure is incorrect"),
    NO_DATA_FOUND("No data found for the requested petition"),
    USER_WITH_ROLE_INVALID("The user does not have a role that allows them to perform this action"),
    OWNER_NOT_AUTHENTICATED("The owner is not authenticated"),
    RESTAURANT_ID_INVALID("The restaurant ID is invalid");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
