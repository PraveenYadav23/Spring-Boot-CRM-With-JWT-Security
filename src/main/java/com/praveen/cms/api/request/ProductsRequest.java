package com.praveen.cms.api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductsRequest {

    List<Long> productsId;
}
