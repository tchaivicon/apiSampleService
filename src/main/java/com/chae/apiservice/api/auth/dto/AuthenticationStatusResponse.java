package com.chae.apiservice.api.auth.dto;

public class AuthenticationStatusResponse {
    private final String txId;
    private final String status;

    public AuthenticationStatusResponse(String txId, String status) {
        this.txId = txId;
        this.status = status;
    }

    public String getTxId() {
        return txId;
    }

    public String getStatus() {
        return status;
    }
}
