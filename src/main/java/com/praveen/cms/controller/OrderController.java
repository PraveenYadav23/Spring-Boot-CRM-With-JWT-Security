package com.praveen.cms.controller;

import com.praveen.cms.constant.RestMappingConstants;
import com.praveen.cms.entity.Customer;
import com.praveen.cms.entity.Product;
import com.praveen.cms.response.CustomerResponse;
import com.praveen.cms.response.ProductResponse;
import com.praveen.cms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestMappingConstants.OrderRequestUri.ORDER_BASE_URL)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(RestMappingConstants.OrderRequestUri.GET_CUSTOMER_BY_ID)
    public CustomerResponse getCustomerDetailByOrderId(@RequestParam("orderId") int orderId){
        return orderService.getCustomerOfOrder(orderId);
    }

    @GetMapping(RestMappingConstants.OrderRequestUri.GET_PRODUCTS_BY_ORDER_ID)
    public List<Product> getProductsByOrderId(@RequestParam("orderId") int orderId){
        return orderService.getProductDetail(orderId);
    }
}