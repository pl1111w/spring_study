package com.pl1111w.webflux.service;

import com.pl1111w.webflux.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/3/29 16:30
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Flux<User> findByAgeBetween(int start, int end);
}
