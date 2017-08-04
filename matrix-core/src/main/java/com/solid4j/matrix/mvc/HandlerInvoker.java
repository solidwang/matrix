package com.solid4j.matrix.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: solidwang
 * @since 1.0
 */
public interface HandlerInvoker {

    void invoker(HttpServletRequest request, HttpServletResponse response, Handler handler);
}
