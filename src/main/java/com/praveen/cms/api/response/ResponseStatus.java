package com.praveen.cms.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {

    private int statusCode;

    public ResponseStatus(){}

    public ResponseStatus(int statusCode) {
        this.statusCode = statusCode;
    }

}
