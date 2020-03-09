package com.praveen.cms.api.dao;

import com.praveen.cms.api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductDao {

    public Page<Product> getProductsList(Pageable pageable);
    public Optional<Product> getProductById(Long productId);
    public Product addNewProductDao(Product product);
    public Product updateProduct(Product product);
    public void deleteProductByIdDao(Long productId);
    public List<Product> getProductsByIdIn(List<Long> productsId);
}
