package com.praveen.cms.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseApiResponse {

    private int responseStatus;
    private Object responseData;
    private String message;


    public BaseApiResponse(Object responseData) {

        this.responseData = responseData;
    }

    public BaseApiResponse() {

        this.responseData = null;
    }

    public BaseApiResponse(boolean error, int responseStatus, Object responseData, String message) {
        super();

        this.responseStatus = responseStatus;
        this.responseData = responseData;
        this.message = message;
    }
}
