package ru.otus.homework06.dao.converters;

import javax.persistence.AttributeConverter;
import java.time.Year;

public class YearAttributeConverter implements AttributeConverter<Year, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Year year) {
        return year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer yearFromDatabase) {
        return Year.of(yearFromDatabase );
    }
}
