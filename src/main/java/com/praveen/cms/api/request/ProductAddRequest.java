package com.praveen.cms.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAddRequest {

    private String name;
    private String description;
    private double price;
}
