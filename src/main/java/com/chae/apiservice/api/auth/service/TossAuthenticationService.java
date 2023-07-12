package com.chae.apiservice.api.auth.service;


import com.chae.apiservice.api.auth.dto.AuthenticationInitiationRequest;
import com.chae.apiservice.api.auth.dto.AuthenticationInitiationResponse;
import com.chae.apiservice.api.auth.dto.AuthenticationResponseWrapper;

public interface TossAuthenticationService {
    AuthenticationResponseWrapper<AuthenticationInitiationResponse> initiateAuthentication(AuthenticationInitiationRequest authenticationInitiationRequest);
    void requestAuthenticationCompletion(String txId);

    }
