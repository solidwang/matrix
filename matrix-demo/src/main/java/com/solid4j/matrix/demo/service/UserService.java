/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.demo.service;

import com.solid4j.matrix.demo.service.impl.UserServiceImpl;
import com.solid4j.matrix.ioc.annotation.Impl;

/**
 * @author: solidwang
 * @since 1.0
 */
@Impl(UserServiceImpl.class)
public interface UserService {

    void insert();
}