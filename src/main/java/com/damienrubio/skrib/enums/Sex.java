package com.damienrubio.skrib.enums;

/**
 * Created by damien on 24/12/2016.
 */
public enum Sex {
    MALE("M"),
    FEMALE("F");

    private String sex;

    Sex(String sex) {
        this.sex=sex;
    }

    public String getSex() {
        return sex;
    }
}
