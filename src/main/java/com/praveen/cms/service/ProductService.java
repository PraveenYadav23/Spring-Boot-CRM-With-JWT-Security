package com.praveen.cms.service;

import com.praveen.cms.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public List<Product> getProductsList();

    public Optional<Product> getProductById(int productId);
    Product addNewProduct(Product product);

    Product updateProduct(Product product);
}
