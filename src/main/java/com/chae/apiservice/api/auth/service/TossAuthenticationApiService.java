package com.chae.apiservice.api.auth.service;

import com.chae.apiservice.api.auth.dto.*;

public interface TossAuthenticationApiService {
    AuthenticationResponseWrapper<AuthenticationInitiationResponse> requestAuthentication(AuthenticationInitiationRequest authenticationInitiationRequest);
    AuthenticationResponseWrapper<AuthenticationStatusResponse> requestAuthenticationStatus();
    AuthenticationResponseWrapper<AuthenticationResultResponse> requestAuthenticationResult();

}
