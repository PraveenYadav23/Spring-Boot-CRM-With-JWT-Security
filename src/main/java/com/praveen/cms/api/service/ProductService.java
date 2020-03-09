package com.praveen.cms.api.service;

import com.praveen.cms.api.bo.ProductAddBo;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.response.ProductAddResponse;
import com.praveen.cms.api.response.ProductDeleteResponse;
import com.praveen.cms.api.response.ProductListResponse;
import com.praveen.cms.api.response.ProductDetailResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public ProductListResponse getProductsList(int page,int limit);
    public ProductDetailResponse getProductById(Long productId);
    public ProductAddResponse addNewProduct(ProductAddBo productAddBo);
    public Product updateProduct(Product product);
    public ProductDeleteResponse deleteProductById(Long productId);
}
