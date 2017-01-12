package com.damienrubio.skrib.enums.converter;

import com.damienrubio.skrib.enums.Gender;

import javax.persistence.AttributeConverter;

/**
 * Created by damien on 11/01/2017.
 */
public class GenderConverter implements AttributeConverter<Gender, String> {
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender.getDbValue();
    }

    @Override
    public Gender convertToEntityAttribute(String value) {
        return Gender.fromDbValue(value);
    }
}
