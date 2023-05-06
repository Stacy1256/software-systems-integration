package org.lnu.teaching.software.systems.integration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends BaseException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
