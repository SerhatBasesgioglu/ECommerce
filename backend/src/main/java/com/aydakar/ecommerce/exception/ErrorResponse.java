package com.aydakar.ecommerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String errorMessage;
    private LocalDateTime timeStamp;
}
