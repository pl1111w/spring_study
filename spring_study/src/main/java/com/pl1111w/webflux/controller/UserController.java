//package com.pl1111w.webflux.controller;
//
//import com.pl1111w.webflux.domain.User;
//import com.pl1111w.webflux.service.UserRepository;
//import com.pl1111w.webflux.util.CheckUtil;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import javax.validation.Valid;
//
///**
// * @title: pl1111w
// * @description:
// * @author: Kris
// * @date 2022/3/29 16:31
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    private final UserRepository userRepository;
//
//    /**
//     * 构造函数的方式注入（官方推荐，降低耦合）
//     */
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/")
//    public Flux<User> getAll() {
//        return userRepository.findAll();
//    }
//
//    /**
//     * 推荐新增另一个相同的方法通过流的方式获取数据
//     * @return
//     */
//    @GetMapping(value = "/stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<User> streamGetAll() {
//        return userRepository.findAll();
//    }
//
//    /**
//     *
//     * @param  user
//     * @return
//     */
//    @PostMapping("/create")
//    public Mono<User> createUser(@Valid @RequestBody User user){
//        return userRepository.save(user);
//    }
//
//    /**
//     *
//     * @param id
//     * @return
//     */
//    @PostMapping("/delete/{id}")
//    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id){
//        return userRepository.findById(id)
//                .flatMap(user -> this.userRepository.delete(user).then(
//                        Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
//                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
//    }
//
//    /**
//     *
//     * @param  id
//     * @return
//     */
//    @GetMapping("/get/{id}")
//    public Mono<User> getUser(@PathVariable String id){
//
//        return userRepository.findById(id);
//    }
//
//    /**
//     *
//     * @param  user
//     * @return
//     */
//    @PostMapping("/update")
//    public Mono<ResponseEntity<User>> updateUser(@Valid @RequestBody User user){
//        CheckUtil.checkName(user.getName());
//        return userRepository.findById(user.getId())
//                .flatMap(u ->{u.setAge(26);u.setName("impulsive");
//                    return  this.userRepository.save(u);})
//                .map(u->new ResponseEntity<User>(u,HttpStatus.OK))
//                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    /**
//     *
//     * @param  start end
//     * @return
//     */
//    @GetMapping("/get/{start}/{end}")
//    public Flux<User> findByAgeUser(@PathVariable int start,@PathVariable int end){
//
//        return userRepository.findByAgeBetween(start,end);
//    }
//
//}
//
