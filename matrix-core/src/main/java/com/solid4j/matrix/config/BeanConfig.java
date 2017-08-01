/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: solidwang
 * @since 1.0
 */
public class BeanConfig {

    // beanMap:bean=>instance
    private static Map<Class<?>, Object> beanMap = new HashMap<>();

    static {
        // 扫描配置的package路径，获取所有的Class
        List<Class<?>> classList = ClassConfig.getClassList();

    }
}