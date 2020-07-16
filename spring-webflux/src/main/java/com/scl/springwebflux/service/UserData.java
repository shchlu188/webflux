package com.scl.springwebflux.service;

import com.scl.springwebflux.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description 模拟数据库
 **********************************/
public class UserData {
    private static final Map<Integer, User> USERS;
    private static final Random RANDOM_AGE;



    static {
        USERS = new HashMap<>();
        RANDOM_AGE = new Random();

        for (int i = 0; i < 100; i++) {

            USERS.put(i, new User(
                    UUID.randomUUID().toString().substring(0, 3),
                    i % 2 == 0 ? "男" : "女",
                    RANDOM_AGE.nextInt(100)));
        }
    }


    public static Map<Integer,User> data(){
        return USERS;
    }

    public static void addUser(User user){
        USERS.put(USERS.size()+1,user);
    }
}
