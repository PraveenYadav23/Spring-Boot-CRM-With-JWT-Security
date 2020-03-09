package com.praveen.cms.api.service;

import com.praveen.cms.api.bo.AddCustomerBo;
import com.praveen.cms.api.entity.Customer;
import com.praveen.cms.api.request.ProductsRequest;
import com.praveen.cms.api.response.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public CustomerListResponse getCustomers(int page,int limit);
    public CustomerDetailResponse getCustomerById(Long customerId);
    public Customer getCustomerByEmail(String email);
    public CustomerAddResponse addCustomer(AddCustomerBo customerBo);
    public Customer updateCustomer(Customer customer);
    public CustomerDeleteResponse deleteCustomer(Long customerId);
    public OrderPlacedResponse purchaseProductsService(Long customerId, ProductsRequest productRequest);
    public PurchasedProductsListResponse viewAllPurchasedProductList(int page,int limit,Long customerId);

   // public List<Customer> searchCustomer(String name);
}
