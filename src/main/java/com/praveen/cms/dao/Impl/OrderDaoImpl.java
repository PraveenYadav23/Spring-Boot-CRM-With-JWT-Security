package com.praveen.cms.dao.Impl;

import com.praveen.cms.dao.OrderDao;
import com.praveen.cms.entity.Customer;
import com.praveen.cms.entity.Product;
import com.praveen.cms.repository.OrderRepository;
import com.praveen.cms.response.CustomerResponse;
import com.praveen.cms.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public CustomerResponse getCustomerByOrder(int orderId) {
        return orderRepository.findCustomerByOrderId(orderId);
    }

    @Override
    public List<Product> getProductDetail(int orderId) {
        return orderRepository.getProductsInfoByOrderId(orderId);
    }
}
