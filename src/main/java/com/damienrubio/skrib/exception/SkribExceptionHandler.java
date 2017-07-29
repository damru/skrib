package com.damienrubio.skrib.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by damien on 29/07/2017.
 */
@ControllerAdvice
@Slf4j
public class SkribExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = SkribException.class)
    protected ResponseEntity<Object> handleSkribException(SkribException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }

}
