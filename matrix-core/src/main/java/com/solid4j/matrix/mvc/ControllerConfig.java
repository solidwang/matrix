/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

import com.solid4j.matrix.config.ClassConfig;
import com.solid4j.matrix.mvc.annotation.Controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller配置
 * @author: solidwang
 * @since 1.0
 */
public class ControllerConfig {

    private static Map<Requester, Handler> controllMap = new HashMap<>();

    static {
        List<Class<?>> classList = ClassConfig.getClassListByAnnotation(Controller.class);
        for(Class cls : classList) {
            Method[] methods = cls.getDeclaredMethods();
            for(Method method : methods) {

            }
        }
    }

    public static Map<Requester, Handler> getControllMap() {
        return controllMap;
    }
}