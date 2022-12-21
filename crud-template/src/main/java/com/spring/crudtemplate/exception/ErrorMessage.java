package com.spring.crudtemplate.exception;

public class ErrorMessage {

    private final String error;
    private final String message;
    private final Integer code;

    ErrorMessage(Exception exception, Integer code) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.code = code;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}