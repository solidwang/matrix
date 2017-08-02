/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.ioc;

import com.solid4j.matrix.config.BeanConfig;
import com.solid4j.matrix.ioc.annotation.Autowire;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

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
            if(!ArrayUtils.isEmpty(fields)) {
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Autowire.class)) {



                    }
                }
            }
        }
    }
}