package com.multipledbs.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 12:00 PM
 */
@Component
@Configuration
public class DataSourceConfiguration {

    @Autowired
    private DataSource1 ds1;

    @Autowired
    private DataSource2 ds2;

    @Bean
    @Primary
    public DynamicRoutingDataSourceResolver dataSource() {
        DynamicRoutingDataSourceResolver resolver = new DynamicRoutingDataSourceResolver();

        Map<Object, Object> dataSources = new HashMap<Object,Object>();
        dataSources.put("db1", ds1.createDataSourceBean());
        dataSources.put("db2", ds2.createDataSourceBean());
        resolver.setTargetDataSources(dataSources);

        // default datasource
        resolver.setDefaultTargetDataSource(ds1.createDataSourceBean());

        return resolver;
    }


}
