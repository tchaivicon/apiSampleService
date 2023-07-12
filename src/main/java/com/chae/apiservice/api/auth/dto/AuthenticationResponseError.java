package com.chae.apiservice.api.auth.dto;

import java.util.Map;

public class AuthenticationResponseError {
    private final String errorType;
    private final String errorCode;
    private final String reason;
    private final Map<String, Object> data;
    private final String title;

    public AuthenticationResponseError(String errorType, String errorCode, String reason, Map<String, Object> data, String title) {
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.reason = reason;
        this.data = data;
        this.title = title;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getReason() {
        return reason;
    }

    public Map<String, Object> getData() {
        return data;
    }
    public String getTitle() {
        return title;
    }
}
