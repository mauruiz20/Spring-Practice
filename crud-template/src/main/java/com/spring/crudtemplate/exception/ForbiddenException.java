package com.spring.crudtemplate.exception;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String detail) {

        super(detail);
    }

}
