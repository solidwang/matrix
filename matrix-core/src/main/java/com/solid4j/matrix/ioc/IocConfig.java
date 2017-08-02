/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.ioc;

import com.solid4j.matrix.config.BeanConfig;
import com.solid4j.matrix.config.ClassConfig;
import com.solid4j.matrix.ioc.annotation.Autowire;
import com.solid4j.matrix.ioc.annotation.Impl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * IOC实现
 * @author: solidwang
 * @since 1.0
 */
public class IocConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(IocConfig.class);

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
                            } else {
                                LOGGER.error("Autowire error, type=" + type);
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
        // 如果接口中含有注解@Impl，直接获取其值
        if (type.isAnnotationPresent(Impl.class)) {
            Class<?> cls = type.getAnnotation(Impl.class).value();
            return cls;
        } else {
            // 否则获取第一个实现类
            List<Class<?>> classList = ClassConfig.getClassListBySuper(type);
            if (CollectionUtils.isNotEmpty(classList)) {
                return classList.get(0);
            }
            return null;
        }
    }
}