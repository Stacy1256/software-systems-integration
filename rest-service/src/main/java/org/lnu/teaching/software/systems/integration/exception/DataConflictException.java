package org.lnu.teaching.software.systems.integration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DataConflictException extends BaseException {
    public DataConflictException(String message) {
        super(message);
    }
}
