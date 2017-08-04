/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

import com.solid4j.matrix.core.InstanceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet分发
 *
 * @author: solidwang
 * @since 1.0
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class ServletDispatcher extends HttpServlet {

    // 请求映射
    private HandlerMapping handlerMapping = InstanceFactory.getHandlerMapping();
    // 请求反射
    private HandlerInvoker handlerInvoker = InstanceFactory.getHandlerInvoker();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求的方法和路径
        String currentMethod = request.getMethod();
        String currentPath = request.getPathInfo();

        Handler handler = handlerMapping.getHander(currentMethod, currentPath);

        handlerInvoker.invoker(request, response, handler);
    }
}