/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.demo.service;

import com.solid4j.matrix.demo.entity.User;
import com.solid4j.matrix.demo.service.impl.UserServiceImpl;
import com.solid4j.matrix.ioc.annotation.Impl;

import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
public interface UserService {

    List<User> findUserList();
}