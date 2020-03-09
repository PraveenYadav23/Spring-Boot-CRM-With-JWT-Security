package com.praveen.cms.api.constant;

public interface AppConstants {


    public interface Common{
        String PAGE_NUMBER = "page";
        String PAGE_LIMIT = "limit";
        String PAGE_LIMIT_VALUE = "150";
        String PAGE_DEFAULT_VALUE = "0";
        boolean BOOLEAN_TRUE_VALUE = true;
        boolean BOOLEAN_FALSE_VALUE = false;
        String TOKEN_HEADER = "Authorization";
    }

    public interface StatusCodes{
        int SUCCESS = 0;
        int FAILURE = 1;
    }

    public interface ErrorTypes{
        String NO_CUSTOMER_FOUND_ERROR = "No Customer Found";
        String NO_PRODUCT_FOUND_ERROR = "No Product Found";
        String EMAIL_ALREADY_REGISTERED_ERROR = "Email Already Registered" ;
    }

    public interface ErrorCodes {
        String CUSTOMER_DOES_NOT_EXISTS_ERROR_CODE = "101";
        String NO_PRODUCT_FOUND_ERROR_CODE = "102";
        String CUSTOMER_ALREADY_EXISTS_ERROR_CODE = "103";
    }

    public interface ErrorMessages {
        String CUSTOMER_NOT_EXISTS_ERROR_MESSAGE = "Customer not found";
        String NO_PRODUCT_FOUND_ERROR_MESSAGE = "Product not found";
        String EMAIL_ALREADY_REGISTERED__MESSAGE = "Email Already Registered";
    }
}
