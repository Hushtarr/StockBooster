package com.stockbooster.dto;

import lombok.Getter;

@Getter
public class ApiMsg {
    private final String message;

    public ApiMsg(String message) {
        this.message = message;
    }
}
