package com.praveen.cms.api.service;

import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.response.CustomerDetailResponse;
import com.praveen.cms.api.response.ProductListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public CustomerDetailResponse getCustomerOfOrder(Long orderId);
    public ProductListResponse getProductDetail(int page,int limit,Long orderId);

}
