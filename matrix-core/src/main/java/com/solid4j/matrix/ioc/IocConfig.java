/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.ioc;

import com.solid4j.matrix.config.BeanConfig;
import com.solid4j.matrix.ioc.annotation.Autowire;
import com.solid4j.matrix.ioc.annotation.Impl;
import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author: solidwang
 * @since 1.0
 */
public class IocConfig {

    static {
        Map<Class<?>, Object> beanMap = BeanConfig.getBeanMap();
        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            Class<?> cls = entry.getKey();
            Object beanInstance = entry.getValue();
            Field[] fields = cls.getDeclaredFields();
            if (!ArrayUtils.isEmpty(fields)) {
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Autowire.class)) {
                        try {
                            Class<?> type = field.getType();
                            Class<?> implClass = getImplClassByType(type);
                            Object instance = beanMap.get(implClass);
                            if (instance != null) {
                                field.setAccessible(true);
                                field.set(beanInstance, instance);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static Class<?> getImplClassByType(Class<?> type) {
        if (type.isAnnotationPresent(Impl.class)) {
            Class<?> cls = type.getAnnotation(Impl.class).value();
            return cls;
        } else {
            return null;
        }
    }
}