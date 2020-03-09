package com.praveen.cms.api.advice;

import com.praveen.cms.api.constant.AppConstants;
import com.praveen.cms.api.exception.AppException;
import com.praveen.cms.api.exception.CustomerNotFoundException;
import com.praveen.cms.api.exception.ProductNotFoundException;
import com.praveen.cms.api.response.BaseApiResponse;
import com.praveen.cms.api.response.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvice1 extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<BaseApiResponse> apiException(AppException appException, HttpServletRequest request){
       BaseApiResponse baseApiResponse = new BaseApiResponse();
       baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.FAILURE));
       baseApiResponse.setResponseData(appException.getErrorMessage());
       return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<BaseApiResponse> customerNotFoundException(CustomerNotFoundException customerNotFoundException, HttpServletRequest request){
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.FAILURE));
        baseApiResponse.setMessage(customerNotFoundException.getErrorMessage());
        baseApiResponse.setResponseData(customerNotFoundException);
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<BaseApiResponse> productNotFoundExceptionHandle(ProductNotFoundException productNotFound,
                                                                          HttpServletRequest request){
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.FAILURE));
        baseApiResponse.setMessage(productNotFound.getErrorMessage());
        baseApiResponse.setResponseData(productNotFound);
        return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }
}
