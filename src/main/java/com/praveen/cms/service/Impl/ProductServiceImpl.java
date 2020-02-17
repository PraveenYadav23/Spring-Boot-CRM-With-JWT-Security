package com.praveen.cms.service.Impl;

import com.praveen.cms.dao.ProductDao;
import com.praveen.cms.entity.Product;
import com.praveen.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getProductsList() {
        return productDao.getProductsList();
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Product addNewProduct(Product product) {
        return productDao.addNewProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }
}
