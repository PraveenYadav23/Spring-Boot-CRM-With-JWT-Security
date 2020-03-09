package com.praveen.cms.api.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductAddBo {

    private String name;
    private String description;
    private double price;
}
