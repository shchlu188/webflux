package com.scl.controller;

import com.scl.service.UserService;
import lombok.Data;

/**
 * @author scl
 * @Date 2020/6/28
 * @Description
 */

public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
