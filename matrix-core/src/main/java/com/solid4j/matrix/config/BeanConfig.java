/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.config;

import com.solid4j.matrix.ioc.annotation.Service;
import com.solid4j.matrix.mvc.annotation.Controller;
import com.solid4j.matrix.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bean初始化
 * @author: solidwang
 * @since 1.0
 */
public class BeanConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanConfig.class);

    // beanMap:bean=>instance
    private static Map<Class<?>, Object> beanMap = new HashMap<>();

    static {
        // 扫描配置的package路径，获取所有的Class
        List<Class<?>> classList = ClassConfig.getClassList();
        // 将含有注解@Controller/@Service的类实例化加载
        for (Class<?> cls : classList) {
            if (cls.isAnnotationPresent(Controller.class)
                    || cls.isAnnotationPresent(Service.class)) {
                String className = cls.getName();
                Object instance = ClassUtil.newInstance(className);
                beanMap.put(cls, instance);
            }
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }
}