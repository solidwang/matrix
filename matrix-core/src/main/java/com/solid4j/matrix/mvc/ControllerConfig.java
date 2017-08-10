/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

import com.solid4j.matrix.config.ClassConfig;
import com.solid4j.matrix.mvc.annotation.Controller;
import com.solid4j.matrix.mvc.annotation.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller配置
 *
 * @author: solidwang
 * @since 1.0
 */
public class ControllerConfig {

    private static Map<Requester, Handler> controllMap = new HashMap<>();

    static {
        List<Class<?>> classList = ClassConfig.getClassListByAnnotation(Controller.class);
        for (Class cls : classList) {
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                handleMethod(cls, method);
            }
        }
    }

    private static void handleMethod(Class cls, Method method) {
        if (method.isAnnotationPresent(Request.Get.class)) {
            String path = method.getAnnotation(Request.Get.class).value();
            controllMap.put(new Requester("GET", path), new Handler(cls, method));
        } else if (method.isAnnotationPresent(Request.Post.class)) {
            String path = method.getAnnotation(Request.Post.class).value();
            controllMap.put(new Requester("POST", path), new Handler(cls, method));
        }
    }

    public static Map<Requester, Handler> getControllMap() {
        return controllMap;
    }
}