package com.praveen.cms.api.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"cause","stackTrace","suppressed","localizedMessage"})
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorType;
    private String errorCode;
    private String errorMessage;

    public AppException(String errorType, String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public AppException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
