package com.ig.springboot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global로 에러처리하는 Controller
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BansongException.class)
    public ResponseEntity<String> handlerException(BansongException e) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
