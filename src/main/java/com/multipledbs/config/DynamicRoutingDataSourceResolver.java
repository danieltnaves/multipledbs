package com.multipledbs.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author tqi_dnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 11:49 AM
 */
public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey () {
        return CustomerContextHolder.getCustomerType().dbName();
    }

}
