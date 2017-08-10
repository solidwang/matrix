/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.core.impl;

import com.solid4j.matrix.core.ClassTemplate;

/**
 * @author: solidwang
 * @since 1.0
 */
public abstract class ClassTemplateForSuper extends ClassTemplate {

    private Class<?> superCls;

    public ClassTemplateForSuper(String packageName, Class<?> superCls) {
        super(packageName);
        this.superCls = superCls;
    }
}