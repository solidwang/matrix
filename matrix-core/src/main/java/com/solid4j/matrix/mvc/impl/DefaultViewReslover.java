/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc.impl;

import com.solid4j.matrix.common.Constants;
import com.solid4j.matrix.mvc.ViewReslover;
import com.solid4j.matrix.mvc.bean.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author: solidwang
 * @since 1.0
 */
public class DefaultViewReslover implements ViewReslover {

    @Override
    public void resloveView(HttpServletRequest request, HttpServletResponse response, Object result) {
        try {
            if (result instanceof View) {
                View view = (View) result;
                String path = Constants.JSP_PATH + view.getPath();
                Map<String, Object> data = view.getData();
                for (Map.Entry<String, Object> map : data.entrySet()) {
                    request.setAttribute(map.getKey(), map.getValue());
                }
                request.getRequestDispatcher(path).forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}