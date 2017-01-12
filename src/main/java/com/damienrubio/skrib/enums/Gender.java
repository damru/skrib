package com.damienrubio.skrib.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by damien on 24/12/2016.
 */
public enum Gender {
    MALE("M", "male"), FEMALE("F", "female");

    private String dbValue;
    private String jsonValue;

    Gender(String dbValue, String jsonValue) {
        this.dbValue = dbValue;
        this.jsonValue = jsonValue;
    }

    public String getDbValue() {
        return this.dbValue;
    }

    @JsonValue
    public String getJsonValue() {
        return jsonValue;
    }

    public static Gender fromDbValue(String dbvalue) {
        switch (dbvalue) {
            case "M" :
                return MALE;
            case "F" :
                return FEMALE;
        }

        return null;
    }

}
