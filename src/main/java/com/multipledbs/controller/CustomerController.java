package com.multipledbs.controller;

import java.util.ArrayList;
import java.util.List;

import com.multipledbs.config.CustomerContextHolder;
import com.multipledbs.domain.Customer;
import com.multipledbs.domain.CustomerType;
import com.multipledbs.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danieltnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 11:56 AM
 */
@RestController
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public List<Customer> listAll() {

        CustomerContextHolder.setCustomerType(CustomerType.DB1);
        final List<Customer> list1 = customerService.list();

        CustomerContextHolder.setCustomerType(CustomerType.DB2);
        final List<Customer> list2 = customerService.list();

        final List<Customer> finalList = new ArrayList<>();
        finalList.addAll(list1);
        finalList.addAll(list2);

        return finalList;

    }

    @RequestMapping("/update")
    public void update() {
        try {
            final Customer customer = new Customer();
            customer.setId(1);
            customer.setFirstName("Transaction test name 2");
            customer.setLastName("Transaction test last name 2");
            customerService.update(customer);
        } catch (RuntimeException e) {
            log.error("Transaction error [roll back]", e);
        }

    }

}
