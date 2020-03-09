package com.praveen.cms.api.entity;

import lombok.Getter;
import lombok.Setter;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product_detail")
public class Product extends BaseEntity {

    //@FullTextField(analyzer = "name")
    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "price")
    private double price;


    public Product(){}

    public Product(String productName, String productDescription, double price) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                ",productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                '}';
    }
}
