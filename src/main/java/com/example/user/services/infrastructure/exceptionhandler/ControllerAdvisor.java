package com.example.user.services.infrastructure.exceptionhandler;

import com.example.user.services.infrastructure.exception.UserIsNotLegalAgeException;
import com.example.user.services.infrastructure.exception.UserNumberDocumentIncorrectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(UserNumberDocumentIncorrectException.class)
    public ResponseEntity<Map<String, String>> handleUserNumberDocumentIncorrectException(
            UserNumberDocumentIncorrectException userNumberDocumentIncorrectException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NUMBER_DOCUMENT_INCORRECT.getMessage()));
    }

    @ExceptionHandler(UserIsNotLegalAgeException.class)
    public ResponseEntity<Map<String, String>> handleUserIsNotLegalAgeException(
            UserIsNotLegalAgeException userIsNotLegalAgeException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_IS_NOT_LEGAL_AGE.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception exception) {
        log.info("Exception arrives:" + exception.getClass().toString());
        String messageException;
        if (exception.getClass().toString().equals("class jakarta.validation.ConstraintViolationException")) {
            messageException = exception.getMessage();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap(exception.getClass().toString(), exception.getMessage()));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, messageException));
    }
}
