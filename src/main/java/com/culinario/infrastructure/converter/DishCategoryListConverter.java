package com.culinario.infrastructure.converter;

import com.culinario.infrastructure.enums.DishCategory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;

@Converter
public class DishCategoryListConverter implements AttributeConverter<List<DishCategory>, String> {
    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<DishCategory> dishCategories) {
        List<String> stringDishes = nonNull(dishCategories) ? dishCategories.stream().map(Enum::name).toList() : Collections.emptyList();
        return stringDishes.isEmpty() ? null : String.join(DELIMITER, stringDishes);
    }

    @Override
    public List<DishCategory> convertToEntityAttribute(String s) {
        return nonNull(s) ?
                Arrays.stream(s.split(DELIMITER)).map(DishCategory::valueOf).toList()
                : Collections.emptyList();
    }

}
