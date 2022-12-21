package com.spring.crudtemplate.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String detail) {

        super(detail);
    }

}
