package com.praveen.cms.advice;

import com.praveen.cms.constant.AppConstant;
import com.praveen.cms.exception.AppException;
import com.praveen.cms.exception.CustomerNotFoundException;
import com.praveen.cms.response.BaseApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvice1 extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<BaseApiResponse> apiException(AppException appException,HttpServletRequest request){
       BaseApiResponse baseApiResponse = new BaseApiResponse();
       baseApiResponse.setResponseStatus(AppConstant.StatusCodes.FAILURE);
       baseApiResponse.setResponseData(appException.getErrorMessage());
       return new ResponseEntity<>(baseApiResponse,HttpStatus.OK);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<BaseApiResponse> customerNotFoundException(CustomerNotFoundException customerNotFoundException, HttpServletRequest request){
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        baseApiResponse.setResponseStatus(HttpStatus.BAD_REQUEST.value());
        baseApiResponse.setMessage(customerNotFoundException.getErrorMessage());
        baseApiResponse.setResponseData(customerNotFoundException);
        return new ResponseEntity<>(baseApiResponse, HttpStatus.BAD_REQUEST);
    }
}
