package com.stockbooster.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ResponseWrapperDTO {
    private boolean success;
    private String message;
    private Integer statusCode;
    private Object data;


    public ResponseWrapperDTO(String message,Object data) {
        this.success = true;
        this.message = message;
        this.statusCode = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapperDTO(String message,HttpStatus status) {
        this.success = false;
        this.message = message;
        this.statusCode = status.value();

    }
}
