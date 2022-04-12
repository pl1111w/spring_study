package com.pl1111w.webflux.advice;

import com.pl1111w.webflux.exceptions.ExceptionDefine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/4/3 17:25
 */
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleException(MethodArgumentNotValidException e) {
        return new ResponseEntity<String>(toStr(e), HttpStatus.BAD_REQUEST);
    }

    private String toStr(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream().map(
                e -> e.getField() + ":" + e.getDefaultMessage()
        ).reduce("", (s1, s2) -> s1 + "\n" + s2);
    }

    @ExceptionHandler(ExceptionDefine.class)
    public ResponseEntity<String> handleExceptionDefine(ExceptionDefine e) {
        return new ResponseEntity<String>(toStr2(e), HttpStatus.BAD_REQUEST);
    }

    private String toStr2(ExceptionDefine ex) {
        return ex.getFieldName() + " ERROR-VALUE :" + ex.getFieldVale();
    }
}
