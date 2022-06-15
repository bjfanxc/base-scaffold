package com.base.scaffold.user.checker;

import com.base.scaffold.user.exception.FieldInvalidException;

public interface FieldChecker<T> {
    void checkField(T busiRequest) throws FieldInvalidException;
}
