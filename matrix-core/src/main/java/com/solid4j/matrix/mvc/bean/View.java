/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * jsp展示层
 * @author: solidwang
 * @since 1.0
 */
public class View implements Serializable {

    private String path;

    private Map<String, Object> data;

    public View(String path) {
        this.path = path;
        data = new HashMap<>();
    }

    public View add(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setPath(String path) {
        this.path = path;
    }
}