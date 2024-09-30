package com.stockbooster.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PAID("paid"), UNPAID("unpaid");
    private final String value;
}
