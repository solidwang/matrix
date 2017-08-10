/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.ds.impl;

import com.solid4j.matrix.ds.DataSourceFactory;
import com.solid4j.matrix.util.ConfigUtil;

import javax.sql.DataSource;

/**
 * @author: solidwang
 * @since 1.0
 */
public abstract class AbstractDataSourceFactory<T extends DataSource> implements DataSourceFactory {

    public final String driver = ConfigUtil.getString("matrix.jdbc.driver");

    public final String url = ConfigUtil.getString("matrix.jdbc.url");

    public final String userName = ConfigUtil.getString("matrix.jdbc.username");

    public final String password = ConfigUtil.getString("matrix.jdbc.passsword");


    @Override
    public final T getDataSource() {
        T ds = createDateSource();
        setDriver(ds, driver);
        setURL(ds, url);
        setUserName(ds, userName);
        setPassword(ds, password);
        return ds;
    }

    public abstract T createDateSource();

    public abstract void setDriver(T ds, String driver);

    public abstract void setURL(T ds, String url);

    public abstract void setUserName(T ds, String userName);

    public abstract void setPassword(T ds, String password);

    public abstract void setAdvancedConfig(T ds);
}