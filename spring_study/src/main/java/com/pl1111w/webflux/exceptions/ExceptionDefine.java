package com.pl1111w.webflux.exceptions;

import lombok.Data;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/4/3 17:47
 */
@Data
public class ExceptionDefine extends RuntimeException{

    private static final long serialVersionUID =1L;

    private String fieldName;

    private String fieldVale;

    public ExceptionDefine() {
        super();
    }

    public ExceptionDefine(String message) {
        super(message);
    }

    public ExceptionDefine(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDefine(Throwable cause) {
        super(cause);
    }

    protected ExceptionDefine(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExceptionDefine(String fieldName, String fieldVale) {
        this.fieldName = fieldName;
        this.fieldVale = fieldVale;
    }
}
