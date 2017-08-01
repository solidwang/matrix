/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class操作工具类
 *
 * @author: solidwang
 * @since 1.0
 */
public class ClassUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    public static Class<?> loadClass(String className) {
        return loadClass(className, true);
    }

    public static Class<?> loadClass(String className, boolean init) {
        try {
            return Class.forName(className, init, getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("loadClass error, className=" + className);
        }
        return null;
    }

    public static <T> T newInstance(String className) {
        try {
            return (T) loadClass(className).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
}