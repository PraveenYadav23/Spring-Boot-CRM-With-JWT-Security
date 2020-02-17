package com.praveen.cms.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Order_detail")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @Column(name="order_date")
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "Order_Product" , joinColumns = {@JoinColumn(name = "order_id")}, inverseJoinColumns = {@JoinColumn(name="product_id")})
    private List<Product> productList;

    public Order(){}

    public Order(int orderId, Date orderDate, Customer customer, List<Product> productList) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", productList=" + productList +
                '}';
    }
}
