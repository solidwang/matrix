/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.core;

import com.solid4j.matrix.util.ClassUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassTemplate.class);

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
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equalsIgnoreCase("file")) {
                        String filePath = url.getPath();
                        addClass(classList, filePath, packageName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classList;
    }

    private void addClass(List<Class<?>> classList, String filePath, String packageName) {
        File[] files = new File(filePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
        for (File file : files) {
            String fileName = file.getName();
            if (file.isFile()) {
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
                String className = packageName + "." + fileName;
                doAddClass(classList, className);
            } else {
                String subFilePath = fileName;
                if (StringUtils.isNotEmpty(subFilePath)) {
                    subFilePath = filePath + "/" + fileName;
                }
                String subPackageName = fileName;
                if (StringUtils.isNotEmpty(subPackageName)) {
                    subPackageName = packageName + "." + fileName;
                }
                addClass(classList, subFilePath, subPackageName);
            }
        }
    }

    private void doAddClass(List<Class<?>> classList, String className) {

        Class<?> cls = ClassUtil.loadClass(className);
        if (checkAddClass(cls)) {
            classList.add(cls);
        }
    }

    protected abstract boolean checkAddClass(Class<?> cls);
}