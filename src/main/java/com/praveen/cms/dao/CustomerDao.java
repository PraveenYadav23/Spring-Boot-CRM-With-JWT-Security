package com.praveen.cms.dao;

import com.praveen.cms.entity.Customer;
import com.praveen.cms.request.CustomerRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDao {

    public List<Customer> getCustomers();
    public Optional<Customer> getCustomerById(int customerId);
    public Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);

    void deleteCustomer(int customerId);
}
