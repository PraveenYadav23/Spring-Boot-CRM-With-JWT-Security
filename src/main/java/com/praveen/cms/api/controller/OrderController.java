package com.praveen.cms.api.controller;

import com.praveen.cms.api.constant.AppConstants;
import com.praveen.cms.api.constant.RestMappingConstants;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.response.BaseApiResponse;
import com.praveen.cms.api.response.CustomerDetailResponse;
import com.praveen.cms.api.response.ProductListResponse;
import com.praveen.cms.api.response.ResponseBuilder;
import com.praveen.cms.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BaseApiResponse> getCustomerDetailByOrderId(
            @RequestParam("orderId") Long orderId)
    {
        CustomerDetailResponse customer = orderService.getCustomerOfOrder(orderId);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(customer);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @GetMapping(RestMappingConstants.OrderRequestUri.GET_PRODUCTS_BY_ORDER_ID)
    public ResponseEntity<BaseApiResponse> getProductsByOrderId(
            @RequestParam("orderId") Long orderId,
            @RequestParam(value = AppConstants.Common.PAGE_NUMBER,defaultValue = "0") int page,
            @RequestParam(value = AppConstants.Common.PAGE_LIMIT,defaultValue = AppConstants.Common.PAGE_LIMIT_VALUE) int limit
    ){

        ProductListResponse products = orderService.getProductDetail(page,limit,orderId);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(products);
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }
}