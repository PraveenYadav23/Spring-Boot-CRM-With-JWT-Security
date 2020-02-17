package com.praveen.cms.service;

import com.praveen.cms.entity.Customer;
import com.praveen.cms.entity.Product;
import com.praveen.cms.response.CustomerResponse;
import com.praveen.cms.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public CustomerResponse getCustomerOfOrder(int orderId);
    public List<Product> getProductDetail(int orderId);

}
