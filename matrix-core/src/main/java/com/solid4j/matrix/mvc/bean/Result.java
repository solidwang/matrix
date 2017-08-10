/*
 * Copyright (c) 2017 solidwang. All Rights Reserved
 */
package com.solid4j.matrix.mvc.bean;

import java.io.Serializable;

/**
 * JSON数据展示
 * @author: solidwang
 * @since 1.0
 */
public class Result implements Serializable {

    private Boolean flag;

    private Object object;

    private Integer errorCode;

    private Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Object object) {
        this.object = object;
    }

    public Result(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}