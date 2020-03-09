package com.praveen.cms.api.service.Impl;

import com.praveen.cms.api.dao.OrderDao;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.response.CommonPaginationResponse;
import com.praveen.cms.api.response.CustomerDetailResponse;
import com.praveen.cms.api.response.ProductDetailResponse;
import com.praveen.cms.api.response.ProductListResponse;
import com.praveen.cms.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public CustomerDetailResponse getCustomerOfOrder(Long orderId) {
        return orderDao.getCustomerByOrder(orderId);
    }

    @Override
    public ProductListResponse getProductDetail(int page,int limit,Long orderId) {
        if(page>0)
            page = page - 1;
        Pageable pageable = PageRequest.of(page,limit);
        List<Product> products = orderDao.getProductDetail(orderId);
        List<ProductDetailResponse> productDetailResponseList = new ArrayList<>();
        for(Product product:products){
            ProductDetailResponse productDetailResponse = new ProductDetailResponse();
            productDetailResponse.setProductId(product.getId());
            productDetailResponse.setDescription(product.getProductDescription());
            productDetailResponse.setPrice(product.getPrice());
            productDetailResponse.setProductName(product.getProductName());
            productDetailResponseList.add(productDetailResponse);
        }
        int start = (int) pageable.getOffset();
        int end = (int)((start+pageable.getPageSize()) > productDetailResponseList.size() ? productDetailResponseList.size() : (start+pageable.getPageSize()));
        Page<ProductDetailResponse> productPages = new PageImpl<>(productDetailResponseList.subList(start,end),pageable,productDetailResponseList.size());
        List<ProductDetailResponse> productList = productPages.getContent();
        CommonPaginationResponse commonPaginationResponse = new CommonPaginationResponse();
        commonPaginationResponse.setTotalNumberOfPageAsPerGivenLimit(productPages.getTotalPages());
        ProductListResponse productListResponse = new ProductListResponse();
        productListResponse.setProductsResponseList(productList);
        productListResponse.setCommonPaginationResponse(commonPaginationResponse);
        return productListResponse;
    }
}
