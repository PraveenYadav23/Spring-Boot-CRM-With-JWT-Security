package com.praveen.cms.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseApiResponse {

    private ResponseStatus responseStatus;
    private Object responseData;
    private String message;


    public BaseApiResponse(Object responseData) {

        this.responseData = responseData;
    }

    public BaseApiResponse() {

        this.responseData = null;
    }

    public BaseApiResponse(ResponseStatus responseStatus, Object responseData, String message) {
        this.responseStatus = responseStatus;
        this.responseData = responseData;
        this.message = message;
    }
}
