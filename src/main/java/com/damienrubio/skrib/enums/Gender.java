package com.damienrubio.skrib.enums;

/**
 * Created by damien on 24/12/2016.
 */
public enum Gender {
    MALE("M"),
    FEMALE("F");

    private String sex;

    Gender(String sex) {
        this.sex=sex;
    }

    public String getSex() {
        return sex;
    }
}
