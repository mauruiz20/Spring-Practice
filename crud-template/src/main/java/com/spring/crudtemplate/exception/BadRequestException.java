package com.spring.crudtemplate.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String detail) {

        super(detail);
    }

}
