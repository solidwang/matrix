/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.util;

import com.solid4j.matrix.common.Constants;

import java.util.Properties;

/**
 * @author: solidwang
 * @since 1.0
 */
public class ConfigUtil {

    private static final Properties configProps = PropUtil.loadProps(Constants.CONFIG_FILE);

    public static String getString(String key) {
        return configProps.getProperty(key);
    }

    public static String getString(String key, String defaultValue) {
        return configProps.getProperty(key, defaultValue);
    }
}