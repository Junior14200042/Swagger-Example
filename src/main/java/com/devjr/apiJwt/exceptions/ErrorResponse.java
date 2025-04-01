package com.devjr.apiJwt.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime localDateTime;

    public ErrorResponse(HttpStatus httpStatus,String message){
        this.httpStatus=httpStatus;
        this.message=message;
        this.localDateTime=LocalDateTime.now();
    }
}
