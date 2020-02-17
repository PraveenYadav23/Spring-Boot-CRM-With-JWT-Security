package com.praveen.cms.repository;

import com.praveen.cms.entity.Customer;
import com.praveen.cms.entity.Order;
import com.praveen.cms.entity.Product;
import com.praveen.cms.response.CustomerResponse;
import com.praveen.cms.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("SELECT new com.praveen.cms.response.CustomerResponse(o.customer.firstName,o.customer.lastName) FROM Order o WHERE o.orderId=:orderId")
    CustomerResponse findCustomerByOrderId(@Param("orderId") Integer orderId);

    @Query("SELECT o.productList FROM Order o WHERE o.orderId=:orderId")
    List<Product> getProductsInfoByOrderId(@Param("orderId") Integer orderId);
}
