/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.core.impl;

import com.solid4j.matrix.core.ClassScanner;
import com.solid4j.matrix.core.ClassTemplate;

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

}