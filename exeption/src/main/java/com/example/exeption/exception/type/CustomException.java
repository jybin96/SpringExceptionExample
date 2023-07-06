package com.example.exeption.exception.type;

import com.example.exeption.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;

    public CustomException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
