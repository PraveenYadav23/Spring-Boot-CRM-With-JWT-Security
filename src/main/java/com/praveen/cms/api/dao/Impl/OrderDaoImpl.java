package com.praveen.cms.api.dao.Impl;

import com.praveen.cms.api.dao.OrderDao;
import com.praveen.cms.api.entity.Order;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.repository.OrderRepository;
import com.praveen.cms.api.response.CustomerDetailResponse;
import com.praveen.cms.api.response.ProductDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public CustomerDetailResponse getCustomerByOrder(Long orderId) {
        return orderRepository.findCustomerByOrderId(orderId);
    }

    @Override
    public List<Product> getProductDetail(Long orderId) {
        return orderRepository.getProductsInfoByOrderId(orderId);
    }

    @Override
    public Long savePurchaseOrder(Order saveOrder) {
        Order order = orderRepository.save(saveOrder);
        Long orderId = order.getId();
        return orderId;
    }

    @Override
    public List<Long> getOrdersIdByCustomerId(Long customerId) {
        return orderRepository.getOrdersIdByCustomerIdRep(customerId);
    }

    @Override
    public List<Order> getOrdersEntityByOrderIdIn(List<Long> orderIds) {
        return orderRepository.findAllById(orderIds);
    }

}
