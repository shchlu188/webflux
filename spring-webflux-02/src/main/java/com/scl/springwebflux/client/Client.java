package com.scl.springwebflux.client;

import com.scl.springwebflux.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description
 **********************************/
public class Client {
    public static void main(String[] args) {
        WebClient client = WebClient.create("http://localhost:13744");
        // 根据id查询
       User user = client.get().uri("/users/{id}",12)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        System.out.println(user);

        // 查询所有
    /*    List<User> users = client.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class)
                .buffer()
                .blockLast();
        users.forEach(System.out::println);
        System.out.println(users.size());*/
        Mono<User> userMono = Mono.just(new User("我是新添加的成员","我的性别是男生",120));
        client.put()
                .uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .body(userMono,User.class)
                .retrieve()
                .toBodilessEntity()
                .block();

    }
}
