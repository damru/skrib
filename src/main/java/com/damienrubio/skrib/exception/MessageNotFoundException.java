package com.damienrubio.skrib.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Created by damien on 28/07/2017.
 */
@Getter
@Setter
public class MessageNotFoundException extends SkribException {

    @Builder
    public MessageNotFoundException(HttpStatus httpStatus, String message, @NonNull Long id) {
        super();
        if (httpStatus == null) {
            super.httpStatus = HttpStatus.NOT_FOUND;
        }
        if (message == null) {
            super.message = "Message was not found. (id: "+id+")";
        }
    }

    public static class MessageNotFoundExceptionBuilder extends SkribExceptionBuilder{
        MessageNotFoundExceptionBuilder() {
            super();
        }
    }

}
