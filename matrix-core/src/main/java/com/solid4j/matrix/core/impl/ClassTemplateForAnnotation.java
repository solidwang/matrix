/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.core.impl;

import com.solid4j.matrix.core.ClassTemplate;

import java.lang.annotation.Annotation;

/**
 * @author: solidwang
 * @since 1.0
 */
public abstract class ClassTemplateForAnnotation extends ClassTemplate {

    private Class<? extends Annotation> annotation;

    public ClassTemplateForAnnotation(String packageName, Class<? extends Annotation> annotation) {
        super(packageName);
        this.annotation = annotation;
    }
}