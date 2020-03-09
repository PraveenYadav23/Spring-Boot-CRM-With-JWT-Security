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
public class CustomerListResponse {

    private List<CustomerDetailResponse> customerDetailResponseList;
    private CommonPaginationResponse commonPaginationResponse;

}
