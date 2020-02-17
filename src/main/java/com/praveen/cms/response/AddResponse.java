package com.praveen.cms.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddResponse {

    private int customerId;

    public AddResponse(){}

    public AddResponse(int customerId) {
        this.customerId = customerId;
    }


}
