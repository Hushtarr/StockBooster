package com.stockbooster.dto.common;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;

// http code handle by response entity

//    if obj needed
    public ApiResponse(String message,Object data) {
        this.success = true;
        this.message = message;
        this.data = data;
    }
//    if it's void or failed
    public ApiResponse(String message) {
        this.success = true;
        this.message = message;
    }

}
