package com.multipledbs.config;

import org.springframework.util.Assert;

import com.multipledbs.domain.CustomerType;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 11:50 AM
 */
public class CustomerContextHolder {

    private static final ThreadLocal<CustomerType> contextHolder =
            new ThreadLocal<CustomerType>();

    public static void setCustomerType(CustomerType customerType) {
        Assert.notNull(customerType, "customerType cannot be null");
        contextHolder.set(customerType);
    }

    public static CustomerType getCustomerType() {
        return (CustomerType) contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }

}
