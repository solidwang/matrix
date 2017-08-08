/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: solidwang
 * @since 1.0
 */
public class WebUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebUtil.class);

    public static void writeJSON(HttpServletResponse response, Object data) {
        try {
            // 设置响应头
            response.setContentType("application/json"); // 指定内容类型为 JSON 格式
            response.setCharacterEncoding("UTF-8"); // 防止中文乱码
            // 向响应中写入数据
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtil.toJSON(data)); // 转为 JSON 字符串
            writer.flush();
            writer.close();
        } catch (Exception e) {
            LOGGER.error("在响应中写数据出错！", e);
            throw new RuntimeException(e);
        }
    }
}