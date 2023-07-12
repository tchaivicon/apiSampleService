package com.chae.apiservice.api.auth.dto;

public class AuthenticationResultRequest {
    private final String txId;
    private final String sessionKey;


    public AuthenticationResultRequest(String txId, String sessionKey) {
        this.txId = txId;
        this.sessionKey = sessionKey;
    }

    public String getTxId() {
        return txId;
    }

    public String getSessionKey() {
        return sessionKey;
    }
}
