package com.praveen.cms.api.entity;


import lombok.Getter;
import lombok.Setter;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
//import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="customer_detail")
//@Indexed(backend = "customer")
public class Customer extends BaseEntity {

    //@FullTextField(analyzer = "name")
    @Column(name="first_name")
    private String firstName;

    //@FullTextField(analyzer = "name")
    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    ///@IndexedEmbedded(maxDepth = 2)
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orderList;

    public Customer(){

    }
    public Customer(String firstName, String lastName, String email,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
