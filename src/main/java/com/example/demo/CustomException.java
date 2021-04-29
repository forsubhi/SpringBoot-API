package com.example.demo;

public class CustomException extends Exception {

    String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

   public CustomException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;

    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
