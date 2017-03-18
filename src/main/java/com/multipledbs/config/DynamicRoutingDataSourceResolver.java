package com.multipledbs.config;

import com.multipledbs.domain.CustomerType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 11:49 AM
 */
public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey () {
        if (CustomerContextHolder.getCustomerType() == null) {
            return CustomerType.DB1.dbName();
        }
        return CustomerContextHolder.getCustomerType().dbName();
    }

}
