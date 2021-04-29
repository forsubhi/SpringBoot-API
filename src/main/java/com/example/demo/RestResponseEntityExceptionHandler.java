package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("generic Error");
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<Object>(
                errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            CustomException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(ex.getErrorCode());
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<Object>(
                errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
