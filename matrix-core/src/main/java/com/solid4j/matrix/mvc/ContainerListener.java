/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

import com.solid4j.matrix.config.ConfigLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * web容器监听
 * @author: solidwang
 * @since 1.0
 */
@WebListener
public class ContainerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //执行配置初始化
        ConfigLoader.init();

        //添加路径映射
        addServletMapping(sce.getServletContext());
    }

    private void addServletMapping(ServletContext servletContext) {
        servletContext.getServletRegistration("jsp").addMapping("/WEB-INF/jsp/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //容器终止
    }
}