package com.damienrubio.skrib.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Created by damien on 28/07/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SkribException extends RuntimeException {

    @Builder.Default
    protected HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    @Builder.Default
    protected String message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

}
