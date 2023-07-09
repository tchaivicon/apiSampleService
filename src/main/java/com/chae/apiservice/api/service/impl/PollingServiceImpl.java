package com.chae.apiservice.api.service.impl;


import com.chae.apiservice.api.service.PollingService;
import org.springframework.stereotype.Service;

@Service
public class PollingServiceImpl implements PollingService {

    int i=4;
    @Override
    public boolean pollingTest() {
        if(i++%3==0) return true;
        return false;
    }
    @Override
    public String requestInformation() {
        // Implementation
        return "cool"; // replace this with actual logic
    }
}
