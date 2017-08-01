/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.config;

import com.solid4j.matrix.util.ClassUtil;

/**
 * 配置加载
 * @author: solidwang
 * @since 1.0
 */
public class ConfigLoader {

    public static void init() {
        Class<?>[] classes = {
            BeanConfig.class
        };

        for(Class<?> cls : classes) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}