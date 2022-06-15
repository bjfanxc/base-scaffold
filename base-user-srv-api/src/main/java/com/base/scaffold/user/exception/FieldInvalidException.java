package com.base.scaffold.user.exception;

public class FieldInvalidException extends BusinessException {

    public FieldInvalidException(int status, String message) {
        super(status, message);
    }
}
