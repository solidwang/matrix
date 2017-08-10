/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.core;

import com.solid4j.matrix.core.impl.DefaultClassScanner;
import com.solid4j.matrix.mvc.HandlerInvoker;
import com.solid4j.matrix.mvc.HandlerMapping;
import com.solid4j.matrix.mvc.ViewReslover;
import com.solid4j.matrix.mvc.impl.DefaultHandlerInvoker;
import com.solid4j.matrix.mvc.impl.DefaultHandlerMapping;
import com.solid4j.matrix.mvc.impl.DefaultViewReslover;
import com.solid4j.matrix.util.ClassUtil;
import com.solid4j.matrix.util.ConfigUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 实例化工厂
 *
 * @author: solidwang
 * @since 1.0
 */
public class InstanceFactory {

    private static String CLASS_SCANNER = "matrix.custom.class_scanner";
    private static String HANDLER_MAPPING = "matrix.custom.handler_mapping";
    private static String HANDLER_INVOKER = "matrix.custom.handler_invoker";
    private static String VIEW_RESLOVER = "matrix.custom.view_reslover";
    private static String DS_FACTORY = "matrix.custom.ds_factory";
    private static String DATA_ACCESSOR = "matrix.custom.data_accessor";

    public static ClassScanner getClassScanner() {
        return getInstance(CLASS_SCANNER, DefaultClassScanner.class);
    }

    public static HandlerMapping getHandlerMapping() {
        return getInstance(HANDLER_MAPPING, DefaultHandlerMapping.class);
    }

    public static HandlerInvoker getHandlerInvoker() {
        return getInstance(HANDLER_INVOKER, DefaultHandlerInvoker.class);
    }

    public static ViewReslover getViewReslover() {
        return getInstance(VIEW_RESLOVER, DefaultViewReslover.class);
    }

    private static <T> T getInstance(String className, Class<T> defaultClass) {
        String defaultName = ConfigUtil.getString(className);
        if (StringUtils.isEmpty(defaultName)) {
            defaultName = defaultClass.getName();
        }
        return ClassUtil.newInstance(defaultName);
    }
}