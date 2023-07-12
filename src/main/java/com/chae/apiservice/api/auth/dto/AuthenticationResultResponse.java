package com.chae.apiservice.api.auth.dto;

public class AuthenticationResultResponse {
    private final String txId;
    private final String status;
    private final String userIdentifier;
    private final String userCiToken;
    private final String signature;
    private final String randomValue;
    private final String completedDt;
    private final String requestedDt;
    private final AuthenticationPersonalData personalData;

    public AuthenticationResultResponse(String txId, String status, String userIdentifier, String userCiToken, String signature, String randomValue, String completedDt, String requestedDt, AuthenticationPersonalData personalData) {
        this.txId = txId;
        this.status = status;
        this.userIdentifier = userIdentifier;
        this.userCiToken = userCiToken;
        this.signature = signature;
        this.randomValue = randomValue;
        this.completedDt = completedDt;
        this.requestedDt = requestedDt;
        this.personalData = personalData;
    }

    public String getTxId() {
        return txId;
    }

    public String getStatus() {
        return status;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getUserCiToken() {
        return userCiToken;
    }

    public String getSignature() {
        return signature;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public String getCompletedDt() {
        return completedDt;
    }

    public String getRequestedDt() {
        return requestedDt;
    }

    public AuthenticationPersonalData getPersonalData() {
        return personalData;
    }
}
