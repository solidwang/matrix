/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.mvc.impl;

import com.solid4j.matrix.mvc.ControllerConfig;
import com.solid4j.matrix.mvc.Handler;
import com.solid4j.matrix.mvc.HandlerMapping;
import com.solid4j.matrix.mvc.Requester;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: solidwang
 * @since 1.0
 */
public class DefaultHandlerMapping implements HandlerMapping {

    @Override
    public Handler getHander(String requestMethod, String requestPath) {
        Handler handler = null;
        Map<Requester, Handler> controllMap = ControllerConfig.getControllMap();
        for(Map.Entry<Requester, Handler> map : controllMap.entrySet()) {
            Requester requester = map.getKey();
            String method = requester.getRequestMethod();
            String path = requester.getRequestPath();
            Matcher requestPathMatcher = Pattern.compile(path).matcher(requestPath);
            if(requestMethod.equalsIgnoreCase(method) && requestPathMatcher.matches()) {
                handler = map.getValue();
                break;
            }
        }
        return handler;
    }
}