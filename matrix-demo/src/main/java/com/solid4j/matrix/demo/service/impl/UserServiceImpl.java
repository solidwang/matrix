/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.demo.service.impl;

import com.solid4j.matrix.demo.entity.User;
import com.solid4j.matrix.demo.service.UserService;
import com.solid4j.matrix.ioc.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> findUserList() {
        List<User> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            User user = new User("solidwang"+i, "solidwang"+i);
            list.add(user);
        }
        return list;
    }
}