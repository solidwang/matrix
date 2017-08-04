package com.solid4j.matrix.mvc;

/**
 * @author: solidwang
 * @since 1.0
 */
public interface HandlerMapping {

    Handler getHander(String requestMethod, String requestPath);

}
