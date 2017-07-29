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
public class UserSettingsNotFoundException extends SkribException {

    @Builder
    public UserSettingsNotFoundException(HttpStatus httpStatus, String message, @NonNull Long id) {
        super();
        if (httpStatus == null) {
            super.httpStatus = HttpStatus.NOT_FOUND;
        }
        if (message == null) {
            super.message = "User settings were not found. (user id : "+id+")";
        }
    }

    public static class UserSettingsNotFoundExceptionBuilder extends SkribExceptionBuilder{
        UserSettingsNotFoundExceptionBuilder() {
            super();
        }
    }

}
