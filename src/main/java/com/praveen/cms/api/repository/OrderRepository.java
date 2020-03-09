package com.praveen.cms.api.repository;

import com.praveen.cms.api.entity.Order;
import com.praveen.cms.api.entity.Product;
import com.praveen.cms.api.response.CustomerDetailResponse;
import com.praveen.cms.api.response.ProductDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT new com.praveen.cms.api.response.CustomerDetailResponse(o.customer.id,o.customer.firstName,o.customer.lastName,o.customer.email) FROM Order o WHERE o.id=:orderId")
    CustomerDetailResponse findCustomerByOrderId(@Param("orderId") Long orderId);

    @Query(value = "SELECT o.productList FROM Order o WHERE o.id=:orderId")
    List<Product> getProductsInfoByOrderId(@Param("orderId") Long orderId);

    @Query(value = "Select o.id FROM Order o WHERE o.customer.id=:customerId")
    public List<Long> getOrdersIdByCustomerIdRep(@Param("customerId") Long customerId);

}
