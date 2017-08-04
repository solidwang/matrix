/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: solidwang
 * @since 1.0
 */
public interface ViewReslover {

    void resloveView(HttpServletRequest request, HttpServletResponse response, Object result);
}