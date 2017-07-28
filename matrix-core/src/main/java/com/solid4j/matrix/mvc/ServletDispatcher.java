/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet分发
 * @author: solidwang
 * @since 1.0
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class ServletDispatcher extends HttpServlet {


}