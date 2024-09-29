package com.stockbooster.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GMapper {
    private final ModelMapper mapper;

    public GMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public <T> T convert(Object before, Class<T> after) {
        return mapper.map(before, after);
    }

}
