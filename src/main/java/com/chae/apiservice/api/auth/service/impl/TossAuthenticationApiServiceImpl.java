package com.chae.apiservice.api.auth.service.impl;

import com.chae.apiservice.api.auth.dto.*;
import com.chae.apiservice.api.auth.service.TossAuthenticationApiService;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TossAuthenticationApiServiceImpl implements TossAuthenticationApiService {
    private String issueToken() {
        return "eyJraWQiOiJjZXJ0IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJ0ZXN0X2E4ZTIzMzM2ZDY3M2NhNzA5MjJiNDg1ZmU4MDZlYjJkIiwiYXVkIjoidGVzdF9hOGUyMzMzNmQ2NzNjYTcwOTIyYjQ4NWZlODA2ZWIyZCIsIm5iZiI6MTY4OTE3NTgwOCwic2NvcGUiOlsiY2EiXSwiaXNzIjoiaHR0cHM6XC9cL2NlcnQudG9zcy5pbSIsImV4cCI6MTcyMDcxMTgwOCwiaWF0IjoxNjg5MTc1ODA4LCJqdGkiOiI3ZDFmNzdlMS1jOThhLTRmNmQtYWQ2Zi0yNTlhZTk0ZDk5MDkifQ.UjVQS3PHcEzBWNh1BNh0XHTelBQN0K1O1hwoJ273O13A26KWOry1ADMhLUbLmsvRKPUUNC40fZN4ImewB2NUztDcQiHQ_N41kKHwxUvB5yn6uXJbz7Vgvj3PhHqFykIR-ow7Kui8pG6c-inscb3KGLXRV7hjl2w3CoklpbyFjJaGqkjxP-77ptkLV9wLzWmKme5B0g3LvtMIK2njfqsP6YPjeVDFLtML9x3mf4RbBH3mZcqJauIqVMi8W_-tY1xj4NPcSVd-_zcyXr6wOZHPLYXrhHdaBpjILhBjRhcZPv3JlkTQcN1T6qsvT7UCLCTpDRA3FwKH9zg81-GCDIncwA";
    }
    int counter=0;
    private static final String txId = "c1ce9214-9878-4751-b433-0c96641b0e13";
    private static final String resultType = "SUCCESS";
    @Override
    public AuthenticationResponseWrapper<AuthenticationInitiationResponse> requestAuthentication(AuthenticationInitiationRequest authenticationInitiationRequest) {
        AuthenticationInitiationResponse authenticationInitiationResponse = new AuthenticationInitiationResponse(txId,"COMPLETED", new HashMap<>());
        AuthenticationResponseError error = null;
        return new AuthenticationResponseWrapper<AuthenticationInitiationResponse>("SUCCESS",authenticationInitiationResponse, error);
    }

    @Override
    public AuthenticationResponseWrapper<AuthenticationStatusResponse> requestAuthenticationStatus() {
        String status = counter++ % 3 == 0 ? "COMPLETED":"REQUESTED";
        AuthenticationStatusResponse authenticationStatusResponse = new AuthenticationStatusResponse(txId,status);
        AuthenticationResponseError error = null;

        return new AuthenticationResponseWrapper<AuthenticationStatusResponse>(resultType, authenticationStatusResponse, error);
    }

    @Override
    public AuthenticationResponseWrapper<AuthenticationResultResponse> requestAuthenticationResult() {
        AuthenticationPersonalData personalData = new AuthenticationPersonalData("","","","","","","","","","","","","");
        AuthenticationResultResponse authenticationResultResponse = new AuthenticationResultResponse(txId, "COMPLETED","","","","","","",personalData);
        AuthenticationResponseError error = null;

        return new AuthenticationResponseWrapper<AuthenticationResultResponse>(resultType, authenticationResultResponse,error);
    }
}
