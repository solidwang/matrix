/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.demo.controller;

import com.solid4j.matrix.core.ClassTemplate;
import com.solid4j.matrix.demo.service.UserService;
import com.solid4j.matrix.ioc.annotation.Autowire;
import com.solid4j.matrix.mvc.annotation.Controller;
import com.solid4j.matrix.mvc.annotation.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: solidwang
 * @since 1.0
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassTemplate.class);

    @Autowire
    private UserService userService;

    @Request.Get("/user")
    public void insert() {
        LOGGER.info("----------insert-----------");
    }
}