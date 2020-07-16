package com.scl.springwebflux.controller;

import com.scl.springwebflux.domain.User;
import com.scl.springwebflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description
 **********************************/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    public Mono<User> getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }
    @GetMapping("/")
    public Flux<User> getUserAll(){
        return userService.getUserAll();
    }
    @PostMapping("/add")
    public Mono<Void> addUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.addUserInfo(userMono);
    }
}
