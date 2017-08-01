/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.core;

import com.solid4j.matrix.core.impl.DefaultClassScanner;
import com.solid4j.matrix.util.ClassUtil;
import com.solid4j.matrix.util.ConfigUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 实例化工厂
 *
 * @author: solidwang
 * @since 1.0
 */
public class InstanceFactory {

    private static String CLASS_SCANNER = "matrix.custom.class_scanner";

    public static ClassScanner getClassScanner() {
        return getInstance(CLASS_SCANNER, DefaultClassScanner.class);
    }

    private static <T> T getInstance(String className, Class<T> defaultClass) {
        String defaultName = ConfigUtil.getString(className);
        if(StringUtils.isEmpty(defaultName)) {
            defaultName = defaultClass.getName();
        }
        return ClassUtil.newInstance(defaultName);
    }
}