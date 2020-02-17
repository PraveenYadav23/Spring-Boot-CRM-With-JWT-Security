package com.praveen.cms.service;

import com.praveen.cms.bo.AddCustomerResponseBo;
import com.praveen.cms.entity.Customer;
import com.praveen.cms.request.CustomerRequest;
import com.praveen.cms.response.AddResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    public List<Customer> getCustomers();
    public Optional<Customer> getCustomerById(int customerId);
    public AddResponse addCustomer(CustomerRequest customerRequest);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(int customerId);
}
