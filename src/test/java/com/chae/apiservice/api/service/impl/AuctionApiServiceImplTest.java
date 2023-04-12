package com.chae.apiservice.api.service.impl;

import com.chae.apiservice.api.dto.RequestAuctionDTO;
import com.chae.apiservice.api.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.enumeration.ApiEndpoint;
import com.chae.apiservice.api.service.RestClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;


public class AuctionApiServiceImplTest {

    private RestClient restClient;
    private AuctionApiServiceImpl auctionService;

    @Before
    public void setUp() {
        restClient = Mockito.mock(RestClient.class);
        auctionService = new AuctionApiServiceImpl();
        auctionService.setRestClient(restClient);
    }

    @Test
    public void testRequestAuction() throws Exception {
        String auctionId = "0000001";
        RequestAuctionDTO request = new RequestAuctionDTO("Product A", "Seller A", "100");
        String responseBody = "{\"auctionId\":\"0000001\",\"auctionProduct\":\"Product A\",\"sellerName\":\"Seller A\",\"initialPrice\":\"100\"}";
        ResponseEntity<String> responseEntity = ResponseEntity.ok(responseBody);

        Mockito.when(restClient.callApi(
                eq(ApiEndpoint.REQUEST_AUCTION.getUrlTemplate().replace("{auctionId}", auctionId)),
                eq(ApiEndpoint.REQUEST_AUCTION.getHttpMethod()),
                eq(request),
                any(HttpHeaders.class)
        )).thenReturn(responseEntity);

        RequestAuctionResponseDTO response = auctionService.requestAuction(auctionId, request);

        assertEquals(auctionId, response.getAuctionId());
        assertEquals(request.getAuctionProduct(), response.getAuctionProduct());
        assertEquals(request.getSellerName(), response.getSellerName());
        assertEquals(request.getInitialPrice(), response.getInitialPrice());

        Mockito.verify(restClient).callApi(
                eq(ApiEndpoint.REQUEST_AUCTION.getUrlTemplate().replace("{auctionId}", auctionId)),
                eq(ApiEndpoint.REQUEST_AUCTION.getHttpMethod()),
                eq(request),
                any(HttpHeaders.class)
        );
    }

    // Implement other auction-related API tests here
}