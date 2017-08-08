/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.demo.controller;

import com.solid4j.matrix.demo.entity.User;
import com.solid4j.matrix.demo.service.UserService;
import com.solid4j.matrix.ioc.annotation.Autowire;
import com.solid4j.matrix.mvc.bean.Result;
import com.solid4j.matrix.mvc.bean.View;
import com.solid4j.matrix.mvc.annotation.Controller;
import com.solid4j.matrix.mvc.annotation.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowire
    private UserService userService;

    @Request.Get("/users")
    public View index() {
        LOGGER.info("----------insert-----------");
        List<User> userlist = userService.findUserList();
        return new View("user.jsp").add("userList", userlist);
    }

    @Request.Get("/result")
    public Result result() {
        return new Result(true);
    }
}