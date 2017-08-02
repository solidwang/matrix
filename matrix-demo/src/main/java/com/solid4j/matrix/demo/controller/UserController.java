/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.demo.controller;

import com.solid4j.matrix.demo.service.UserService;
import com.solid4j.matrix.ioc.annotation.Autowire;
import com.solid4j.matrix.mvc.annotation.Controller;

/**
 * @author: solidwang
 * @since 1.0
 */
@Controller
public class UserController {

    @Autowire
    private UserService userService;


}