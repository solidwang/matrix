/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc.impl;

import com.solid4j.matrix.config.BeanConfig;
import com.solid4j.matrix.mvc.Handler;
import com.solid4j.matrix.mvc.HandlerInvoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
public class DefaultHandlerInvoker implements HandlerInvoker {

    @Override
    public void invoker(Handler handler) {
        Class<?> cls = handler.getControllClass();
        Method method = handler.getMethod();
        Object instance = BeanConfig.getBean(cls);
        Object result = invokeMethod(method, instance);

    }

    private Object invokeMethod(Method method, Object instance) {
        List<Object> list = new ArrayList<>();
        try {
            return method.invoke(instance, list.toArray());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}