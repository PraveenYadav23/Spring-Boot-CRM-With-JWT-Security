package com.praveen.cms.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedProductsListResponse {

    List<ProductDetailResponse> productDetailResponseList;
    CommonPaginationResponse commonPaginationResponse;
}
