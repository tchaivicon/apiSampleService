package com.chae.apiservice.api.auth.controller;

import com.chae.apiservice.api.auth.dto.AuthenticationInitiationRequest;
import com.chae.apiservice.api.auth.dto.AuthenticationInitiationResponse;
import com.chae.apiservice.api.auth.dto.AuthenticationResponseWrapper;
import com.chae.apiservice.api.auth.service.TossAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TossAuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(TossAuthenticationController.class);
    private final TossAuthenticationService tossAuthenticationService;

    @Autowired
    public TossAuthenticationController(TossAuthenticationService tossAuthenticationService) {
        this.tossAuthenticationService = tossAuthenticationService;
    }

    @GetMapping("/api/v1/auth/toss/request")
    public AuthenticationResponseWrapper<AuthenticationInitiationResponse> requestAuthenticationInitiation
            (AuthenticationInitiationRequest authenticationInitiationRequest) {
        return tossAuthenticationService.initiateAuthentication(authenticationInitiationRequest);
    }

    @GetMapping("/api/v1/auth/toss/result")
    public void requestAuthenticationCompletion() {
        String txId = "";
        tossAuthenticationService.requestAuthenticationCompletion(txId);
    }

}
