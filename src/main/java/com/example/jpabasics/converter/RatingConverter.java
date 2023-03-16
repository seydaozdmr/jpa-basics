package com.example.jpabasics.converter;

import com.example.jpabasics.model.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false) //true eğer @Convert üzerinde belirtilmemişse kullanılır
public class RatingConverter implements AttributeConverter<Rating,Integer> {

    @Override
    public Integer convertToDatabaseColumn(Rating rating) {
        if(rating == null) return  null;
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(Integer integer) {
        if(integer==null) return null;
        if(integer == 100) return Rating.STANDART;
        else return Rating.PREMIUM;
    }
}
