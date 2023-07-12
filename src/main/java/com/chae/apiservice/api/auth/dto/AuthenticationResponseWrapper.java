package com.chae.apiservice.api.auth.dto;
public class AuthenticationResponseWrapper<T> {
    private String resultType;
    private T success;
    private AuthenticationResponseError error;

    public AuthenticationResponseWrapper(String resultType, T success, AuthenticationResponseError error) {
        this.resultType = resultType;
        this.success = success;
        this.error = error;
    }

    public AuthenticationResponseWrapper(String resultType, T success) {
        this.resultType = resultType;
        this.success = success;
    }

    public String getResultType() {
        return resultType;
    }

    public T getSuccess() {
        return success;
    }

    public AuthenticationResponseError getError() {
        return error;
    }
}
