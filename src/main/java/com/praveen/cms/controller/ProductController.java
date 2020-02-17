package com.praveen.cms.controller;

import com.praveen.cms.constant.RestMappingConstants;
import com.praveen.cms.entity.Product;
import com.praveen.cms.response.BaseApiResponse;
import com.praveen.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestMappingConstants.ProductRequestUri.PRODUCT_BASE_URL)
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = RestMappingConstants.ProductRequestUri.GET_PRODUCT_LIST)
    public List<Product> getProductsList(){
        return productService.getProductsList();
    }

    @GetMapping(path = RestMappingConstants.ProductRequestUri.GET_PRODUCT_BY_ID)
    public Optional<Product> getProductById(@RequestParam("productId") int productId){
        return productService.getProductById(productId);
    }

    @PostMapping(path = RestMappingConstants.ProductRequestUri.ADD_PRODUCT)
    public Product addProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @PutMapping(path = RestMappingConstants.ProductRequestUri.UPDATE_PRODUCT)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1  = productService.updateProduct(product);
        return new ResponseEntity<>(product1,HttpStatus.OK);
    }
}
