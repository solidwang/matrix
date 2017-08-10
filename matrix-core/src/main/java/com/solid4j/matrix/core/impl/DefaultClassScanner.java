/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.core.impl;

import com.solid4j.matrix.core.ClassScanner;
import com.solid4j.matrix.core.ClassTemplate;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
public class DefaultClassScanner implements ClassScanner {

    @Override
    public List<Class<?>> getClassList(String packageName) {
        return new ClassTemplate(packageName) {
            @Override
            protected boolean checkAddClass(Class<?> cls) {
                return true;
            }
        }.getClassList();
    }

    @Override
    public List<Class<?>> getClassListBySuper(String packageName, final Class<?> superCls) {
        return new ClassTemplateForSuper(packageName, superCls) {
            @Override
            protected boolean checkAddClass(Class<?> cls) {
                return superCls.isAssignableFrom(cls) && !superCls.equals(cls);
            }
        }.getClassList();
    }

    @Override
    public List<Class<?>> getClassListByAnnotation(String packageName, final Class<? extends Annotation> annotation) {
        return new ClassTemplateForAnnotation(packageName, annotation) {
            @Override
            protected boolean checkAddClass(Class<?> cls) {
                return cls.isAnnotationPresent(annotation);
            }
        }.getClassList();
    }

}