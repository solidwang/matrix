/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.demo.entity;

import com.solid4j.matrix.orm.annotation.Entity;

import java.io.Serializable;

/**
 * @author: solidwang
 * @since 1.0
 */
@Entity
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}