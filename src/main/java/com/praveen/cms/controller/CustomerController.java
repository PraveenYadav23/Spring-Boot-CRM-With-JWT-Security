package com.praveen.cms.controller;

import com.praveen.cms.bo.AddCustomerResponseBo;
import com.praveen.cms.constant.RestMappingConstants;
import com.praveen.cms.entity.Customer;
import com.praveen.cms.request.CustomerIdRequest;
import com.praveen.cms.request.CustomerRequest;
import com.praveen.cms.response.AddResponse;
import com.praveen.cms.response.BaseApiResponse;
import com.praveen.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestMappingConstants.CustomerRequestUri.Customer_BASE_URL)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //@GetMapping("/customers")
    @GetMapping(path = RestMappingConstants.CustomerRequestUri.GET_CUSTOMER_LIST)
    public List<Customer> getCustomers(){
        List<Customer> customerList = customerService.getCustomers();
        return customerList;
    }

    @GetMapping(path= RestMappingConstants.CustomerRequestUri.GET_CUSTOMER_BY_ID)
    public Optional<Customer> getCustomerById(@RequestParam("customerId") int id){
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer;
    }

    @PostMapping(path = RestMappingConstants.CustomerRequestUri.ADD_CUSTOMER)
    public ResponseEntity<AddResponse> addCustomer(@Valid @RequestBody(required = true) CustomerRequest customerRequest){
         AddResponse addCustResponse= customerService.addCustomer(customerRequest);
        return ResponseEntity.ok(addCustResponse);
    }

    @PutMapping(path=RestMappingConstants.CustomerRequestUri.UPDATE_CUSTOMER)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
         Customer theCust = customerService.updateCustomer(customer);
         return new ResponseEntity<>(theCust, HttpStatus.OK);
    }

    @DeleteMapping(path = RestMappingConstants.CustomerRequestUri.DELETE_CUSTOMER)
    public ResponseEntity<String> deleteCustomer(@RequestParam("customerId") int customerId) {

        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Success");
    }
}
