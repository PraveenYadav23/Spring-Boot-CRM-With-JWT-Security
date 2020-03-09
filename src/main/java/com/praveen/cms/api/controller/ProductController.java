package com.praveen.cms.api.controller;

import com.praveen.cms.api.bo.ProductAddBo;
import com.praveen.cms.api.constant.AppConstants;
import com.praveen.cms.api.constant.RestMappingConstants;
import com.praveen.cms.api.convertor.ProductConvertor;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.request.ProductAddRequest;
import com.praveen.cms.api.response.*;
import com.praveen.cms.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(RestMappingConstants.ProductRequestUri.PRODUCT_BASE_URL)
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = RestMappingConstants.ProductRequestUri.GET_PRODUCT_LIST)
    public ResponseEntity<BaseApiResponse> getProductsList(
            @RequestParam(value = AppConstants.Common.PAGE_NUMBER,defaultValue = "0") int page,
            @RequestParam(value = AppConstants.Common.PAGE_LIMIT,defaultValue = AppConstants.Common.PAGE_LIMIT_VALUE) int limit
    )
    {
        ProductListResponse productResponseList = productService.getProductsList(page,limit);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(productResponseList);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @GetMapping(path = RestMappingConstants.ProductRequestUri.GET_PRODUCT_BY_ID)
    public ResponseEntity<BaseApiResponse> getProductById(
            @RequestParam("productId") Long productId)
    {
        ProductDetailResponse product =  productService.getProductById(productId);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(product);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @PostMapping(path = RestMappingConstants.ProductRequestUri.ADD_PRODUCT)
    public ResponseEntity<BaseApiResponse> addProduct(
            @Valid @RequestBody(required = true) ProductAddRequest productRequest)
    {
        ProductAddBo productBo = ProductConvertor.convertProductAddRequestToProductAddBo(productRequest);
        ProductAddResponse productAddResponse = productService.addNewProduct(productBo);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(productAddResponse);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @PutMapping(path = RestMappingConstants.ProductRequestUri.UPDATE_PRODUCT)
    public ResponseEntity<Product> updateProduct(
            @RequestBody Product product)
    {
        Product productResponse  = productService.updateProduct(product);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @DeleteMapping(path = RestMappingConstants.ProductRequestUri.DELETE_PRODUCT)
    public ResponseEntity<BaseApiResponse> deleteProduct(
            @RequestParam("productId") Long productId)
    {
        ProductDeleteResponse productDeleteResponse = productService.deleteProductById(productId);
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(productDeleteResponse);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }
}
