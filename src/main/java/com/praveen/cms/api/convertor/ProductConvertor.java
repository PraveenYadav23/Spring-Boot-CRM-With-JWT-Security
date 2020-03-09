package com.praveen.cms.api.convertor;

import com.praveen.cms.api.bo.ProductAddBo;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.request.ProductAddRequest;

public class ProductConvertor {

    public static ProductAddBo convertProductAddRequestToProductAddBo(ProductAddRequest productRequest){
        ProductAddBo productAddBo = new ProductAddBo();
        productAddBo.setName(productRequest.getName());
        productAddBo.setDescription(productRequest.getDescription());
        productAddBo.setPrice(productRequest.getPrice());
        return productAddBo;
    }

    public static Product convertProductAddBoToProductEntity(ProductAddBo productBo){
        Product product = new Product();
        product.setPrice(productBo.getPrice());
        product.setProductDescription(productBo.getDescription());
        product.setProductName(productBo.getName());
        return product;
    }
}
