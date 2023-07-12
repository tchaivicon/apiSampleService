package com.chae.apiservice.api.auth.dto;

public class AuthenticationInitiationRequest {
    private final String requestType;
    private final String triggerType;
    private final String sessionKey;
    private final String userPhone;
    private final String userName;
    private final String userBirthday;


    public AuthenticationInitiationRequest(String requestType, String triggerType, String sessionKey, String userPhone, String userName, String userBirthday) {
        this.requestType = requestType;
        this.triggerType = triggerType;
        this.sessionKey = sessionKey;
        this.userPhone = userPhone;
        this.userName = userName;
        this.userBirthday = userBirthday;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserBirthday() {
        return userBirthday;
    }
}
