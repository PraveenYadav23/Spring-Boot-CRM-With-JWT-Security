package com.praveen.cms.api.dao.Impl;

import com.praveen.cms.api.dao.ProductDao;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getProductsList(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product addNewProductDao(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductByIdDao(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getProductsByIdIn(List<Long> productsId) {
        return productRepository.getProductsByIdInRep(productsId);
    }
}
