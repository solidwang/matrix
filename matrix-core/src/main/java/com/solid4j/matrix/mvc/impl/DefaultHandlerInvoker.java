/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc.impl;

import com.solid4j.matrix.config.BeanConfig;
import com.solid4j.matrix.core.InstanceFactory;
import com.solid4j.matrix.mvc.Handler;
import com.solid4j.matrix.mvc.HandlerInvoker;
import com.solid4j.matrix.mvc.ViewReslover;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
public class DefaultHandlerInvoker implements HandlerInvoker {

    // 视图控制
    private ViewReslover viewReslover = InstanceFactory.getViewReslover();

    @Override
    public void invoker(HttpServletRequest request, HttpServletResponse response, Handler handler) {
        Class<?> cls = handler.getControllClass();
        Method method = handler.getMethod();
        Object instance = BeanConfig.getBean(cls);
        Object result = invokeMethod(method, instance);

        viewReslover.resloveView(request, response, result);
    }

    private Object invokeMethod(Method method, Object instance) {
        // 获取方法参数集合
        List<Object> list = new ArrayList<>();
        try {
            // 反射执行方法，得到返回结果
            return method.invoke(instance, list.toArray());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}