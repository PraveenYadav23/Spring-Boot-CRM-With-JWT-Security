package com.praveen.cms.exception;

public class CustomerNotFoundException extends AppException {

    public CustomerNotFoundException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }

}
