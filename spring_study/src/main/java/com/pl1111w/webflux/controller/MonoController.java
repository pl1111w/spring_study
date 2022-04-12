package com.pl1111w.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/3/26 12:33
 */
@RestController
@Slf4j
public class MonoController {

    @RequestMapping("mvc")
    public String mvc() {
        Long start = System.currentTimeMillis();
        String doSomething = doSomething();
        Long end = System.currentTimeMillis();
        log.info("mvc totalTime:{} ", end - start);
        return doSomething;
    }

    @RequestMapping("mono")
    public Mono<String> mono() {
        Long start = System.currentTimeMillis();
        Mono<String> result = Mono.fromSupplier(()->doSomething());
        Long end = System.currentTimeMillis();
        log.info("mono totalTime: {} ", end - start);
        return result;
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<String> flux() {
        Long start = System.currentTimeMillis();
        Flux<String> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "flux data-- " + i;
        }));
        Long end = System.currentTimeMillis();
        log.info("flux totalTime: {} ", end - start);
        return result;
    }

    private String doSomething() {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "done";
    }
}
