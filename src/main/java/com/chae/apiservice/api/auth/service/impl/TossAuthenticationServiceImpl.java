package com.chae.apiservice.api.auth.service.impl;


import com.chae.apiservice.api.auth.dto.*;
import com.chae.apiservice.api.auth.service.TossAuthenticationApiService;
import com.chae.apiservice.api.auth.service.TossAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class TossAuthenticationServiceImpl implements TossAuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(TossAuthenticationServiceImpl.class);
    private final TossAuthenticationApiService tossAuthenticationApiService;
    private final int MAX_ATTEMPTS = 5;
    private final int POLLING_INTERVAL = 1; // in seconds

    @Autowired
    public TossAuthenticationServiceImpl(TossAuthenticationApiService tossAuthenticationApiService) {
        this.tossAuthenticationApiService = tossAuthenticationApiService;
    }

    @Override
    public AuthenticationResponseWrapper<AuthenticationInitiationResponse> initiateAuthentication(AuthenticationInitiationRequest authenticationInitiationRequest) {
        return tossAuthenticationApiService.requestAuthentication(authenticationInitiationRequest);
    }

    @Override
    public void requestAuthenticationCompletion(String txId) {
        CompletableFuture<AuthenticationResponseWrapper<AuthenticationResultResponse>> completableFuture = new CompletableFuture<>();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger attemptCount = new AtomicInteger(0);

        executor.scheduleAtFixedRate(() -> {
            AuthenticationResponseWrapper<AuthenticationStatusResponse> response = tossAuthenticationApiService.requestAuthenticationStatus();
            if ("SUCCESS".equals(response.getResultType())) {
                if("COMPLETED".equals(response.getSuccess().getStatus())){
                    AuthenticationResponseWrapper<AuthenticationResultResponse> result = tossAuthenticationApiService.requestAuthenticationResult();
                    completableFuture.complete(result);
                    executor.shutdownNow();
                }

            } else {
                int attempts = attemptCount.incrementAndGet();
                log.info("Attempt: {}", attempts);
                System.out.println("Attempt: {}"+ attempts);
                if (attempts >= MAX_ATTEMPTS) {
                    completableFuture.completeExceptionally(new RuntimeException("Job timed out"));
                    executor.shutdownNow();
                }
            }
        }, 0, POLLING_INTERVAL, TimeUnit.SECONDS);
    }
}
