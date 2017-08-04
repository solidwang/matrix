/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.demo.service.impl;

import com.solid4j.matrix.core.ClassTemplate;
import com.solid4j.matrix.demo.service.UserService;
import com.solid4j.matrix.ioc.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: solidwang
 * @since 1.0
 */
@Service

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void findUserList() {
        LOGGER.info("-----findUserList=========");
    }
}