package com.pl1111w.aop.controller;

import com.pl1111w.aop.annotations.Annotation;
import com.pl1111w.aop.serviveImpl.ArithmeticCalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopLogController {
    @Autowired
    private ArithmeticCalculatorServiceImpl arithmeticCalculatorService;

    @Annotation
    @GetMapping("/add-logging")
    public int addLogging() {

        int result = arithmeticCalculatorService.add(1, 2);
        return result;
    }

    @GetMapping("/sub-logging")
    public int subLogging() {

        int result = arithmeticCalculatorService.sub(1, 0);
        return result;
    }

    @GetMapping("/mul-logging")
    public int mulLogging() {

        int result = arithmeticCalculatorService.mul(1, 0);
        return result;
    }

    @Annotation
    @GetMapping("/div-logging")
    public int divLogging() {

        int result = arithmeticCalculatorService.div(1, 0);
        return result;
    }
}
