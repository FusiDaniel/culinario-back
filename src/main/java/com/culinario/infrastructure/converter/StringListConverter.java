package com.culinario.infrastructure.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;


@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {
    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return nonNull(stringList) ? String.join(DELIMITER, stringList) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return nonNull(string) ? Arrays.asList(string.split(DELIMITER)) : Collections.emptyList();
    }
}
