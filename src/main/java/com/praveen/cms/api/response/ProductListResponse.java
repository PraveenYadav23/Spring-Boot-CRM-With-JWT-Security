package com.praveen.cms.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse {

    List<ProductDetailResponse> productsResponseList;
    CommonPaginationResponse commonPaginationResponse;

    public ProductListResponse(List<ProductDetailResponse> productsResponseList) {
        this.productsResponseList = productsResponseList;
    }
}
