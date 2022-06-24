package com.example.full_code_quynv.controller;

import com.example.full_code_quynv.constant.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            IllegalArgumentException.class
    })
    protected ResponseEntity<Object> handlerOrderNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessage.builder().code(Constant.ORDER_NOT_FOUND).message(exception.getMessage()).build());
    }

    @ExceptionHandler(value = {
            Exception.class
    })
    protected ResponseEntity<Object> handlerSystemError(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessage.builder().code(Constant.INTERNAL_SERVER_ERROR).message(exception.getMessage()).build());
    }
}

