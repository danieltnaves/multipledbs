package com.multipledbs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.multipledbs.domain.Customer;

/**
 * @author tqi_dnaves
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 3/17/17 11:09 AM
 */
@Repository
public class CustomerRepository {

    public static final String LIST = "SELECT * FROM customer";
    public static final String UPDATE = "UPDATE customer SET firstName = ?, lastName = ? WHERE id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> list() {
        return jdbcTemplate.query(LIST, new UserRowMapper());
    }

    public int update(Customer customer) {
        return jdbcTemplate.update(UPDATE, customer.getFirstName(), customer.getLastName(), customer.getId());
    }

}

class UserRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setFirstName(rs.getString("firstName"));
        customer.setLastName(rs.getString("lastName"));
        customer.setId(rs.getInt("id"));
        return customer;
    }

}
