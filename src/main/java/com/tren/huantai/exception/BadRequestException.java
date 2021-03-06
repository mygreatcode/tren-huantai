package com.tren.huantai.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception caused by bad request.
 *
 * @author johnniang
 */
public class BadRequestException extends HuantaiException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
