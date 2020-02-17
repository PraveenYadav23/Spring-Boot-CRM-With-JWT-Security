package com.praveen.cms.response;

import com.praveen.cms.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponse {

    List<Product> productsResponse;
}
