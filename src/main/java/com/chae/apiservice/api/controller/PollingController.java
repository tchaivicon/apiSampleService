package com.chae.apiservice.api.controller;

import com.chae.apiservice.api.service.PollingService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
public class PollingController {
    private static final Logger logger = LoggerFactory.getLogger(PollingController.class);
    private final PollingService pollingService;
    private final int MAX_ATTEMPTS = 5;
    private final int POLLING_INTERVAL = 1;
    private final int INITIAL_VALUE_ZERO = 0;

    @GetMapping("/api/v2/polling")
    public CompletableFuture<String> pollingTest(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger attemptCount = new AtomicInteger(INITIAL_VALUE_ZERO);
        executorService.scheduleAtFixedRate(()->{
            boolean isDone = pollingService.pollingTest();
            if(isDone){
                String information = pollingService.requestInformation();
                completableFuture.complete(information);
                executorService.shutdown();
            }else{
                int attempts = attemptCount.incrementAndGet();
                logger.info("Attempt: {}", attempts);
                if(attempts >= MAX_ATTEMPTS){
                    completableFuture.completeExceptionally(new RuntimeException("information not received"));
                    executorService.shutdown();
                }
            }
        },INITIAL_VALUE_ZERO, POLLING_INTERVAL, TimeUnit.SECONDS);
        return completableFuture;
    }
}
