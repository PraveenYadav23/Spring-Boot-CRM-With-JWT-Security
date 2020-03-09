package com.praveen.cms.api.response;

import com.praveen.cms.api.constant.AppConstants;
import com.praveen.cms.api.exception.AppException;

public class ResponseBuilder {

    public static BaseApiResponse getSuccessResponse(Object responseData) throws AppException{

    BaseApiResponse baseApiResponse = new BaseApiResponse();
    baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.SUCCESS));
    baseApiResponse.setResponseData(responseData);
    return baseApiResponse;

    }

    public static BaseApiResponse getSuccessResponse(){

        BaseApiResponse baseApiResponse = new BaseApiResponse();
        baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.SUCCESS));
        baseApiResponse.setResponseData(null);
        return baseApiResponse;
    }
}
