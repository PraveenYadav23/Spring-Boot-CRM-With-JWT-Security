package com.praveen.cms.api.dao;

import com.praveen.cms.api.bo.AddCustomerBo;
import com.praveen.cms.api.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDao {

    public Page<Customer> getCustomers(Pageable pageable);
    public Optional<Customer> getCustomerById(Long customerId);
    public Customer getCustomerByEmailDao(String email);
    public Customer addCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(Long customerId);
    public Long checkIfEmailAlreadyExist(String email);

    //public List<Customer> searchCustomerDao(String name);
}
