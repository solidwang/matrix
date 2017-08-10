/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: solidwang
 * @since 1.0
 */
public class StringUtil {

    public static String humpToUnderLine(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for(int i=0; matcher.find(); i++) {
            builder.replace(matcher.start() + i, matcher.end() + i, "_" + matcher.group().toLowerCase());
        }
        if(builder.charAt(0)=='_') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        humpToUnderLine("UserTest");
    }
}