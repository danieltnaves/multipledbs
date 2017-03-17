package com.multipledbs.service;

import java.util.List;

import com.multipledbs.domain.Customer;

/**
 * @author tqi_dnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 5:17 PM
 */
public interface CustomerService {

    List<Customer> list();
    void update(Customer customer) throws Exception;

}
