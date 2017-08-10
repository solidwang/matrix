/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.common;

import com.solid4j.matrix.util.ConfigUtil;
import com.solid4j.matrix.util.PropUtil;

/**
 * @author: solidwang
 * @since 1.0
 */
public class Constants {

    public static final String CONFIG_FILE = "matrix.properties";

    public static final String SQL_PROPS = "matrix-sql.properties";

    public static final String SCAN_PACKAGE = "matrix.app.scan_package";

    public static final String JSP_PATH = ConfigUtil.getString("matrix.app.jsp_path", "/WEB-INF/jsp/");

    public static final String PK_NAME = "id";
}