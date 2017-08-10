package com.solid4j.matrix.ds;

import javax.sql.DataSource;

/**
 * @author: solidwang
 * @since 1.0
 */
public interface DataSourceFactory {

    DataSource getDataSource();
}
