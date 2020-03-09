package com.praveen.cms.api.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.GeneratorType;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
//import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Order_detail")
public class Order extends BaseEntity {

    @Column(name="order_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //@IndexedEmbedded
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "Order_Product" , joinColumns = {@JoinColumn(name = "order_id")}, inverseJoinColumns = {@JoinColumn(name="product_id")})
    private List<Product> productList;

    public Order(){}

    public Order(Date orderDate, Customer customer, List<Product> productList) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                ", customer=" + customer +
                ", productList=" + productList +
                '}';
    }
}
