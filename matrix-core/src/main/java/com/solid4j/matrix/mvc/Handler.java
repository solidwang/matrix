/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

import java.lang.reflect.Method;

/**
 * http处理
 *
 * @author: solidwang
 * @since 1.0
 */
public class Handler {

    private Class<?> controllClass;

    private Method method;

    public Handler(Class<?> controllClass, Method method) {
        this.controllClass = controllClass;
        this.method = method;
    }

    public Class<?> getControllClass() {
        return controllClass;
    }

    public void setControllClass(Class<?> controllClass) {
        this.controllClass = controllClass;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}