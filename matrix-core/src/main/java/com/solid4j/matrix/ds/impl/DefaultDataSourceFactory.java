/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.ds.impl;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author: solidwang
 * @since 1.0
 */
public class DefaultDataSourceFactory extends AbstractDataSourceFactory<BasicDataSource> {

    @Override
    public BasicDataSource createDateSource() {
        return new BasicDataSource();
    }

    @Override
    public void setDriver(BasicDataSource ds, String driver) {
        ds.setDriverClassName(driver);
    }

    @Override
    public void setURL(BasicDataSource ds, String url) {
        ds.setUrl(url);
    }

    @Override
    public void setUserName(BasicDataSource ds, String userName) {
        ds.setUsername(userName);
    }

    @Override
    public void setPassword(BasicDataSource ds, String password) {
        ds.setPassword(password);
    }

    @Override
    public void setAdvancedConfig(BasicDataSource ds) {
        ds.setValidationQuery("select 1 from dual");
    }
}