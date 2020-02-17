package com.praveen.cms.service.Impl;

import com.praveen.cms.dao.OrderDao;
import com.praveen.cms.entity.Customer;
import com.praveen.cms.entity.Product;
import com.praveen.cms.response.CustomerResponse;
import com.praveen.cms.response.ProductResponse;
import com.praveen.cms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public CustomerResponse getCustomerOfOrder(int orderId) {
        return orderDao.getCustomerByOrder(orderId);
    }

    @Override
    public List<Product> getProductDetail(int orderId) {
        return orderDao.getProductDetail(orderId);
    }
}
