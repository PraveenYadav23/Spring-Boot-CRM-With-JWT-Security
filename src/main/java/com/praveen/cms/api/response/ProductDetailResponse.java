package com.praveen.cms.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponse {

    private Long productId;
    private String productName;
    private String description;
    private double price;
}
