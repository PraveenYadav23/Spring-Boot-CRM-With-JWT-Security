package com.praveen.cms.api.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"cause","stackTrace","suppressed","localizedMessage"})
public class CustomerNotFoundException extends AppException {

    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }

}
