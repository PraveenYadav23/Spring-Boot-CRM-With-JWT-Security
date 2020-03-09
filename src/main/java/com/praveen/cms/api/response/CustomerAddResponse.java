package com.praveen.cms.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAddResponse {

    private Long customerId;

    public CustomerAddResponse(){}

    public CustomerAddResponse(Long customerId) {
        this.customerId = customerId;
    }


}
