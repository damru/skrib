package com.damienrubio.skrib.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Position {
    private double latitude;

    private double longitude;

    private double altitude;
}
