package com.damienrubio.skrib.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by damien on 15/01/2017.
 */
@Data
@AllArgsConstructor
public class InfoMessage {

    private String moduleName;
    private String objectName;
    private String fieldName;
    private String fieldValue;
    private String message;
    private Criticity criticity;

}
