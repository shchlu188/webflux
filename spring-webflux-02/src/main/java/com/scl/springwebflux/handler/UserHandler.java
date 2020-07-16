package com.scl.springwebflux.handler;

import com.scl.springwebflux.domain.User;
import com.scl.springwebflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description
 **********************************/
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        // 获取路径id
        Integer id = Integer.valueOf(request.pathVariable("id"));
        // 查询
        Mono<User> userMono = userService.getUserById(id);

        // 转换

        return userMono.flatMap(person ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(person)))
                .switchIfEmpty(
                        ServerResponse.notFound().build()
                );
    }



    public Mono<ServerResponse> getUserAll(ServerRequest request){
        Flux<User> userFlux = this.userService.getUserAll();


        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userFlux,User.class);
    }


    public Mono<ServerResponse> addUser(ServerRequest request){
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse
                .ok()
                .build(this.userService.addUserInfo(userMono));

    }
}
