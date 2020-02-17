package com.praveen.cms.dao;

import com.praveen.cms.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductDao {

    public List<Product> getProductsList();

    public Optional<Product> getProductById(int productId);

    Product addNewProduct(Product product);

    Product updateProduct(Product product);
}
