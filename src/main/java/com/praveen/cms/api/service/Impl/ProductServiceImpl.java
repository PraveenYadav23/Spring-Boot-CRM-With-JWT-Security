package com.praveen.cms.api.service.Impl;

import com.praveen.cms.api.bo.ProductAddBo;
import com.praveen.cms.api.constant.AppConstants;
import com.praveen.cms.api.convertor.ProductConvertor;
import com.praveen.cms.api.dao.ProductDao;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.exception.ProductNotFoundException;
import com.praveen.cms.api.response.*;
import com.praveen.cms.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductListResponse getProductsList(int page,int limit)
    {
        if(page > 0)
            page = page - 1;
        Pageable pageable = PageRequest.of(page,limit);
        Page<Product> productsPage = productDao.getProductsList(pageable);
        List<Product> products = productsPage.getContent();
        List<ProductDetailResponse> productList = new ArrayList<>();
        for(Product product : products){
            ProductDetailResponse productDetailResponse = new ProductDetailResponse();
            productDetailResponse.setProductId(product.getId());
            productDetailResponse.setProductName(product.getProductName());
            productDetailResponse.setDescription(product.getProductDescription());
            productDetailResponse.setPrice(product.getPrice());
            productList.add(productDetailResponse);
        }
        CommonPaginationResponse commonPaginationResponse = new CommonPaginationResponse();
        commonPaginationResponse.setTotalNumberOfPageAsPerGivenLimit(productsPage.getTotalPages());
        ProductListResponse productListResponse = new ProductListResponse();
        productListResponse.setProductsResponseList(productList);
        productListResponse.setCommonPaginationResponse(commonPaginationResponse);
        return productListResponse;
    }

    @Override
    public ProductDetailResponse getProductById(Long productId) {
        Optional<Product> optionalProduct = productDao.getProductById(productId);
        optionalProduct.orElseThrow(
                () -> new ProductNotFoundException(AppConstants.ErrorTypes.NO_PRODUCT_FOUND_ERROR,
                        AppConstants.ErrorCodes.NO_PRODUCT_FOUND_ERROR_CODE,AppConstants.ErrorMessages.NO_PRODUCT_FOUND_ERROR_MESSAGE)
        );
        Product product = optionalProduct.get();
        ProductDetailResponse productDetailResponse = new ProductDetailResponse();
        productDetailResponse.setProductId(product.getId());
        productDetailResponse.setProductName(product.getProductName());
        productDetailResponse.setDescription(product.getProductDescription());
        productDetailResponse.setPrice(product.getPrice());
        return productDetailResponse;
    }

    @Override
    public ProductAddResponse addNewProduct(ProductAddBo productAddBo) {
       Product product = ProductConvertor.convertProductAddBoToProductEntity(productAddBo);
       Product productAdd = productDao.addNewProductDao(product);
       Long productId = productAdd.getId();
       ProductAddResponse productAddResponse = new ProductAddResponse(productId);
       return productAddResponse;
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public ProductDeleteResponse deleteProductById(Long productId) {
        try{
            productDao.deleteProductByIdDao(productId);
        }
        catch (EmptyResultDataAccessException ex){
            throw new ProductNotFoundException(AppConstants.ErrorTypes.NO_PRODUCT_FOUND_ERROR,
                    AppConstants.ErrorCodes.NO_PRODUCT_FOUND_ERROR_CODE,AppConstants.ErrorMessages.NO_PRODUCT_FOUND_ERROR_MESSAGE);
        }
        ProductDeleteResponse productDeleteResponse = new ProductDeleteResponse(true);
        return productDeleteResponse;
    }
}
