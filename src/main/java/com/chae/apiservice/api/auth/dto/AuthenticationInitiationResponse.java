package com.chae.apiservice.api.auth.dto;

import java.util.Map;

public class AuthenticationInitiationResponse {
    private final String txId;
    private final String status;
    private final Map<String, String> appUri;

    public AuthenticationInitiationResponse(String txId, String status, Map<String, String> appUri) {
        this.txId = txId;
        this.status = status;
        this.appUri = appUri;
    }

    public String getTxId() {
        return txId;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, String> getAppUri() {
        return appUri;
    }
}
