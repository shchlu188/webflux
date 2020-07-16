package com.scl.springwebflux.service;

import com.scl.springwebflux.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description
 **********************************/
public interface UserService {
    /**
     * 根据id查询
     * @param id user Id
     * @return
     */
   Mono<User> getUserById(Integer id);

    /**
     * 查询所有user
     * @return
     */
   Flux<User> getUserAll();

    /**
     * 添加user
     * @param user 用户
     * @return
     */
   Mono<Void> addUserInfo(Mono<User> user);

}
