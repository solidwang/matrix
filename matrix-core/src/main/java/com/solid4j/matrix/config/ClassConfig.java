/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.config;

import com.solid4j.matrix.common.Constants;
import com.solid4j.matrix.core.ClassScanner;
import com.solid4j.matrix.core.InstanceFactory;
import com.solid4j.matrix.util.ConfigUtil;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
public class ClassConfig {

    private static String scanPackage = ConfigUtil.getString(Constants.SCAN_PACKAGE);

    private static ClassScanner classScanner = InstanceFactory.getClassScanner();

    public static List<Class<?>> getClassList() {
        return classScanner.getClassList(scanPackage);
    }

    public static List<Class<?>> getClassListBySuper(Class<?> superCls) {
        return classScanner.getClassListBySuper(scanPackage, superCls);
    }

    public static List<Class<?>> getClassListByAnnotation(Class<? extends Annotation> annotation) {
        return classScanner.getClassListByAnnotation(scanPackage, annotation);
    }
}