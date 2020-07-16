package com.scl.springwebflux.service;

import com.scl.springwebflux.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description
 **********************************/
@Service
public class UserServiceImpl implements UserService{
    @Override
    public Mono<User> getUserById(Integer id) {
        return Mono.justOrEmpty(UserData.data().get(id));
    }

    @Override
    public Flux<User> getUserAll() {
        return Flux.fromIterable(UserData.data().values());
    }

    @Override
    public Mono<Void> addUserInfo(Mono<User> user) {
        return user.doOnNext(UserData::addUser)
                .thenEmpty(Mono.empty());
    }
}
