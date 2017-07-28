/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

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
        //执行初始化
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //容器终止
    }
}