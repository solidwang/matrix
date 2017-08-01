/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.core;

import com.solid4j.matrix.util.ClassUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
public abstract class ClassTemplate {

    private String packageName;

    public ClassTemplate(String packageName) {
        this.packageName = packageName;
    }

    public List<Class<?>> getClassList() {
        List<Class<?>> classList = new ArrayList<>();
        try {
            Enumeration<URL> urls = ClassUtil.getClassLoader().getResources(packageName.replace(".", "/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if(url != null) {
                    String protocol = url.getProtocol();
                    if(protocol.equalsIgnoreCase("file")) {
                        String path = url.getPath();
                        System.out.println("path=" + path);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classList;
    }

}