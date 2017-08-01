/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties工具
 * @author: solidwang
 * @since 1.0
 */
public class PropUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropUtil.class);

    public static Properties loadProps(String propsPath) {
        if (StringUtils.isEmpty(propsPath)) {
            throw new IllegalArgumentException();
        }
        Properties props = new Properties();
        InputStream is = ClassUtil.getClassLoader().getResourceAsStream(propsPath);
        try {
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("加载属性文件出错！", e);
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                LOGGER.error("关闭流出错！", e);
            }
        }
        return props;
    }

    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.contains(key)) {
            value = props.getProperty(key);
        }
        return value;
    }
}