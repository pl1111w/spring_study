package com.pl1111w.webflux.util;

import com.pl1111w.webflux.exceptions.ExceptionDefine;

import java.util.stream.Stream;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/4/3 17:47
 */
public class CheckUtil {

    private static final String[] INVALID_NAMES = {"root", "admin", "tester"};

    public static void checkName(String value) {
        Stream.of(INVALID_NAMES).filter(name -> name.equalsIgnoreCase(value)).findAny()
                .ifPresent(n -> {
                    throw new ExceptionDefine("name", value);
                });
    }
}
