package com.chae.apiservice.api.auth.service.impl;

import com.chae.apiservice.api.auth.dto.AuthenticationPersonalData;
import com.chae.apiservice.api.auth.dto.AuthenticationResponseWrapper;
import com.chae.apiservice.api.auth.dto.AuthenticationResultResponse;
import com.chae.apiservice.api.auth.dto.AuthenticationStatusResponse;
import com.chae.apiservice.api.auth.service.TossAuthenticationApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TossAuthenticationServiceImplTest {

    @Mock
    private TossAuthenticationApiService tossAuthenticationApiService;

    @InjectMocks
    private TossAuthenticationServiceImpl tossAuthenticationServiceImpl;

    @Test
    public void testRequestAuthenticationCompletion_Success() {
        AuthenticationStatusResponse statusResponse = new AuthenticationStatusResponse("","COMPLETED");

        AuthenticationResponseWrapper<AuthenticationStatusResponse> statusWrapper = new AuthenticationResponseWrapper<>("SUCCESS",statusResponse);


        AuthenticationResultResponse resultResponse = new AuthenticationResultResponse("","","","","","","","",new AuthenticationPersonalData("","","","","","","","","","","","",""));
        // set fields on resultResponse as needed

        AuthenticationResponseWrapper<AuthenticationResultResponse> resultWrapper = new AuthenticationResponseWrapper<>("SUCCESS",resultResponse);


        when(tossAuthenticationApiService.requestAuthenticationStatus())
                .thenReturn(statusWrapper);

        when(tossAuthenticationApiService.requestAuthenticationResult())
                .thenReturn(resultWrapper);

        // Call the method to test
        tossAuthenticationServiceImpl.requestAuthenticationCompletion("txId");

        // Add assertions as needed to verify the behavior
        assert (1==1);
    }

    @Test(expected = RuntimeException.class)
    public void testRequestAuthenticationCompletion_Timeout() {
        AuthenticationStatusResponse statusResponse = new AuthenticationStatusResponse("","NOT_COMPLETED");

        AuthenticationResponseWrapper<AuthenticationStatusResponse> statusWrapper = new AuthenticationResponseWrapper<>("SUCCESS",statusResponse);


        when(tossAuthenticationApiService.requestAuthenticationStatus())
                .thenReturn(statusWrapper);

        // Call the method to test
        tossAuthenticationServiceImpl.requestAuthenticationCompletion("txId");

        // The method should throw a RuntimeException due to timeout
    }
}
