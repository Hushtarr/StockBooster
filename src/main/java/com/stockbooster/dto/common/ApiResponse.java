package com.stockbooster.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;
// http code handle by response entity

// this mean there will be only 2 type of response format,

//    if obj needed
    public ApiResponse(Boolean success,String message,Object data) {
        this.success = success; //boolean will be return with in method, so only need to give msg/msg+obj
        this.message = message;
        this.data = data;
    }
//    if it's void or failed
    public ApiResponse(Boolean success,String message) {
        this.success = success;
        this.message = message;
    }


//——————————————————————————————————————————————————————————


    public static ApiResponse successVoid(String message) {
        return new ApiResponse(true, message);
    }

    public static ApiResponse successReturn(String message, Object data) {
        return new ApiResponse(true, message, data);
    }

    public static ApiResponse failure(String message) {
        return new ApiResponse(false, message);
    }

}
