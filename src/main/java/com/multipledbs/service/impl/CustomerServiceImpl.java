package com.multipledbs.service.impl;

import java.util.List;

import com.multipledbs.config.CustomerContextHolder;
import com.multipledbs.domain.Customer;
import com.multipledbs.domain.CustomerType;
import com.multipledbs.repository.CustomerRepository;
import com.multipledbs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 5:17 PM
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> list() {
        return customerRepository.list();
    }

    @Override
    @Transactional
    /*
     * Dummy method to test Transaction rollback in multiple DBs
     */
    public void update(Customer customer)  {
        /*
         * Here I'm setting the database hardcoded, but you
         * can use whatever strategy to change database. (i.e annotations, interceptors, etc)
         */
        CustomerContextHolder.setCustomerType(CustomerType.DB1);
        customerRepository.update(customer);
        if (true) throw new RuntimeException("Dummy transaction RuntimeException");
        CustomerContextHolder.setCustomerType(CustomerType.DB2);
        customerRepository.update(customer);
    }
}
