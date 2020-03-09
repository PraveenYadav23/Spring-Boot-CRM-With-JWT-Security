package com.praveen.cms.api.repository;

import com.praveen.cms.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "Select c FROM Customer c WHERE c.email=:email")
    public Customer findByEmail(@Param("email") String email);

    @Query(value = "SELECT count(*) FROM Customer c WHERE c.email=:email")
    public Long countByEmail(@Param("email") String email);
}
