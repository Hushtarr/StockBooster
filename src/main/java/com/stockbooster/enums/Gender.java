package com.stockbooster.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    M("Male"),F("Female");
    private final String value;
}
