package com.multipledbs.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 2:48 PM
 */
public class AbstractDatasourceProperties {

    @Autowired
    DatasourceBaseProperties dataSourceProperties;

    protected String url;
    protected String username;
    protected String password;

    @Bean
    public DataSource createDataSourceBean() {
        DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName(this.dataSourceProperties.getDriverClassName());

        ds.setMaxActive(this.dataSourceProperties.getMaxActive());
        ds.setMaxIdle(this.dataSourceProperties.getMaxIdle());
        ds.setMinIdle(this.dataSourceProperties.getMinIdle());
        ds.setInitialSize(this.dataSourceProperties.getInitialSize());

        ds.setValidationQuery(this.dataSourceProperties.getValidationQuery());
        ds.setTestOnBorrow(this.dataSourceProperties.getTestOnBorrow());
        ds.setTestWhileIdle(this.dataSourceProperties.getTestWhileIdle());
        ds.setTimeBetweenEvictionRunsMillis(this.dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        ds.setMinEvictableIdleTimeMillis(this.dataSourceProperties.getMinEvictableIdleTimeMillis());

        ds.setUrl(this.getUrl());
        ds.setUsername(this.getUsername());
        ds.setPassword(this.getPassword());
        return ds;
    }

    public DatasourceBaseProperties getDataSourceProperties () {
        return dataSourceProperties;
    }

    public void setDataSourceProperties (final DatasourceBaseProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (final String url) {
        this.url = url;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (final String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (final String password) {
        this.password = password;
    }
}
