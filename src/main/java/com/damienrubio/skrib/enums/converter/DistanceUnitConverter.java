package com.damienrubio.skrib.enums.converter;

import com.damienrubio.skrib.enums.DistanceUnit;

import javax.persistence.AttributeConverter;

/**
 * Created by damien on 11/01/2017.
 */
public class DistanceUnitConverter implements AttributeConverter<DistanceUnit, String> {
    @Override
    public String convertToDatabaseColumn(DistanceUnit distanceUnit) {
        return distanceUnit.getDbValue();
    }

    @Override
    public DistanceUnit convertToEntityAttribute(String value) {
        return DistanceUnit.fromDbValue(value);
    }
}
