/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.demo.aspect;

import com.solid4j.matrix.aop.AspectProxy;
import com.solid4j.matrix.aop.annotation.Aspect;
import com.solid4j.matrix.mvc.annotation.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author: solidwang
 * @since 1.0
 */
@Aspect(annotation = Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private Long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        LOGGER.info("-----begin----");
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) {
        Long end = System.currentTimeMillis();
        LOGGER.info("time=" + (end-begin));
        LOGGER.info("----end----");
    }
}