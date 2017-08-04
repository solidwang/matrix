/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.common;

import com.solid4j.matrix.util.ConfigUtil;
import com.solid4j.matrix.util.PropUtil;

/**
 * @author: solidwang
 * @since 1.0
 */
public class Constants {

    public static String CONFIG_FILE = "matrix.properties";

    public static String SCAN_PACKAGE = "matrix.app.scan_package";

    public static String JSP_PATH = ConfigUtil.getString("matrix.app.jsp_path", "/WEB-INF/jsp/");

}