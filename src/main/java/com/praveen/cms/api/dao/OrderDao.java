package com.praveen.cms.api.dao;

import com.praveen.cms.api.entity.Order;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.response.CustomerDetailResponse;
import com.praveen.cms.api.response.ProductDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {

    public CustomerDetailResponse getCustomerByOrder(Long orderId);
    public List<Product> getProductDetail(Long orderId);
    public Long savePurchaseOrder(Order order);
    public List<Long> getOrdersIdByCustomerId(Long customerId);
    public List<Order> getOrdersEntityByOrderIdIn(List<Long> orderIds);
}
