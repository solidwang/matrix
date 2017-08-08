/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.aop;

import com.solid4j.matrix.aop.proxy.Proxy;
import com.solid4j.matrix.aop.proxy.ProxyChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author: solidwang
 * @since 1.0
 */
public abstract class AspectProxy implements Proxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();
        if (intecept(cls, method, params)) {
            before(cls, method, params);
            result = proxyChain.doProxyChain();
            after(cls, method, params, result);
        } else {
            result = proxyChain.doProxyChain();
        }
        return result;
    }


    public void before(Class<?> cls, Method method, Object[] params) {

    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) {

    }

    public boolean intecept(Class<?> cls, Method method, Object[] params) {
        return true;
    }

}