package com.praveen.cms.dao;

import com.praveen.cms.entity.Customer;
import com.praveen.cms.entity.Product;
import com.praveen.cms.response.CustomerResponse;
import com.praveen.cms.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {

    public CustomerResponse getCustomerByOrder(int orderId);
    public List<Product> getProductDetail(int orderId);
}
