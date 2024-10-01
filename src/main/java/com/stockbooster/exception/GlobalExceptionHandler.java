package com.stockbooster.exception;

import com.stockbooster.dto.common.ApiInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiInfo> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiInfo.failure("An unexpected error occurred. Please try again later."));
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiInfo> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiInfo.failure(exception.getMessage()));
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiInfo> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiInfo.failure(exception.getMessage()));
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiInfo> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(ApiInfo.failure(exception.getMessage()));
    }

}
