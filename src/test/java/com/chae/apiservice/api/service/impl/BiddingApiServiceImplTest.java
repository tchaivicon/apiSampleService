package com.chae.apiservice.api.service.impl;

import com.chae.apiservice.api.enumeration.ApiEndpoint;
import com.chae.apiservice.api.service.RestClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class BiddingApiServiceImplTest {

    private RestClient restClient;
    private BiddingApiServiceImpl biddingService;

    @Before
    public void setUp() {
        restClient = Mockito.mock(RestClient.class);
        biddingService = new BiddingApiServiceImpl();
        biddingService.setRestClient(restClient);
    }

    @Test
    public void testSelectAuction() {
        String auctionId = "0000001";
        String biddingId = "001";

        biddingService.selectAuction(auctionId, biddingId);

        Mockito.verify(restClient).callApi(
                eq(ApiEndpoint.SELECT_AUCTION.getUrlTemplate().replace("{auctionId}", auctionId).replace("{biddingId}", biddingId)),
                eq(ApiEndpoint.SELECT_AUCTION.getHttpMethod()),
                eq(null),
                any(HttpHeaders.class)
        );
    }

// Implement other bidding-related API tests here
}