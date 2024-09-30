package com.stockbooster.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperTool {
    private final ModelMapper mapper;
    public <T> T convert(Object before, Class<T> after) {
        return mapper.map(before, after);
    }
}
