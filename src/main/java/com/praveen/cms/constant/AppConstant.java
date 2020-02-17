package com.praveen.cms.constant;

public interface AppConstant {


    public interface Common{
        boolean BOOLEAN_TRUE_VALUE = true;
        boolean BOOLEAN_FALSE_VALUE = false;
    }

    public interface StatusCodes{
        int SUCCESS = 0;
        int FAILURE = 1;
    }

    public interface ErrorTypes{
        String NO_CUSTOMER_FOUND_ERROR = "No Customer Found Error.";
    }

    public interface ErrorCodes {
        String CUSTOMER_DOES_NOT_EXISTS_ERROR_CODE = "101";
    }

    public interface ErrorMessages {
        String CUSTOMER_NOT_EXISTS_ERROR_MESSAGE = "Customer not found";
    }
}
