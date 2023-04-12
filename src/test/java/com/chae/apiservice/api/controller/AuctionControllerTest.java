package com.chae.apiservice.api.controller;

import com.chae.apiservice.api.dto.RequestAuctionDTO;
import com.chae.apiservice.api.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.service.AuctionApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuctionControllerTest {

    private AuctionApiService auctionApiService;
    private AuctionController auctionController;

    @BeforeEach
    public void setUp() {
        auctionApiService = Mockito.mock(AuctionApiService.class);
        auctionController = new AuctionController(auctionApiService);
    }

    @Test
    public void testRequestAuction() {
        String auctionId = "0000001";
        RequestAuctionDTO request = new RequestAuctionDTO("Product A", "Seller A", "100");
        RequestAuctionResponseDTO expectedResponse = new RequestAuctionResponseDTO(auctionId, "Product A", "Seller A", "100");

        Mockito.when(auctionApiService.requestAuction(auctionId, request)).thenReturn(expectedResponse);

        ResponseEntity<RequestAuctionResponseDTO> responseEntity = auctionController.requestAuction(auctionId, request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());

        Mockito.verify(auctionApiService).requestAuction(auctionId, request);
    }

    // Implement other tests related to auction endpoints here
}