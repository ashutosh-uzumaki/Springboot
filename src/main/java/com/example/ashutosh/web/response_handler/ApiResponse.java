package com.example.ashutosh.web.response_handler;

import com.example.ashutosh.web.exception.ApiError;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class ApiResponse<T> {
    @JsonFormat(pattern = "hh:mm:ss dd-mm-yyyy")
    private LocalDateTime timeStamp;
    private T data;

    public ApiResponse() {
        timeStamp = LocalDateTime.now();
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    private ApiError apiError;

    public ApiResponse(T data){
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError){
        this();
        this.apiError = apiError;
    }
}
