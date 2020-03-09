package com.praveen.cms.api.repository;

import com.praveen.cms.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "Select * from product_detail where id in(:productsId)",nativeQuery = true)
    List<Product> getProductsByIdInRep(@Param("productsId") List<Long> productsId);
}
