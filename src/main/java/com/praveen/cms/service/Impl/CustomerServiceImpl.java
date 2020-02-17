package com.praveen.cms.service.Impl;

import com.praveen.cms.bo.AddCustomerResponseBo;
import com.praveen.cms.constant.AppConstant;
import com.praveen.cms.dao.CustomerDao;
import com.praveen.cms.entity.Customer;
import com.praveen.cms.exception.CustomerNotFoundException;
import com.praveen.cms.request.CustomerRequest;
import com.praveen.cms.response.AddResponse;
import com.praveen.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.NewThreadAction;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    public Optional<Customer> getCustomerById(int customerId) {
        Optional<Customer> customerOptional = customerDao.getCustomerById(customerId);
        customerOptional.orElseThrow(
                () -> new CustomerNotFoundException(AppConstant.ErrorTypes.NO_CUSTOMER_FOUND_ERROR, AppConstant.ErrorCodes.CUSTOMER_DOES_NOT_EXISTS_ERROR_CODE, AppConstant.ErrorMessages.CUSTOMER_NOT_EXISTS_ERROR_MESSAGE)
        );

        return customerOptional;
    }

    @Override
    public AddResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = new Customer();
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());
        Customer theCustomer = customerDao.addCustomer(customer);
        int customerId = theCustomer.getId();
        return new AddResponse(customerId);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        try{
            customerDao.deleteCustomer(customerId);
        }
        catch(EmptyResultDataAccessException exc){
            throw new CustomerNotFoundException(AppConstant.ErrorTypes.NO_CUSTOMER_FOUND_ERROR, AppConstant.ErrorCodes.CUSTOMER_DOES_NOT_EXISTS_ERROR_CODE, AppConstant.ErrorMessages.CUSTOMER_NOT_EXISTS_ERROR_MESSAGE);
        }
    }

}
