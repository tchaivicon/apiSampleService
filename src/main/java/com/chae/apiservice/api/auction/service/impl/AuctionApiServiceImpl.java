package com.chae.apiservice.api.auction.service.impl;

import com.chae.apiservice.api.auction.dto.RequestAuctionDTO;
import com.chae.apiservice.api.auction.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.auction.service.AuctionApiService;
import com.chae.apiservice.api.auction.service.RestClient;
import com.chae.apiservice.api.auction.enumeration.ApiEndpointEnumeration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class AuctionApiServiceImpl implements AuctionApiService {

    private RestClient restClient;

    @Autowired
    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public RequestAuctionResponseDTO requestAuction(String auctionId, RequestAuctionDTO request) {
        String url = ApiEndpointEnumeration.REQUEST_AUCTION.getUrlTemplate().replace("{auctionId}", auctionId);
        HttpMethod httpMethod = ApiEndpointEnumeration.REQUEST_AUCTION.getHttpMethod();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = restClient.callApi(url, httpMethod, request, headers);
        // Process the response
        if(response.getStatusCode()!= HttpStatus.OK){
            throw new RuntimeException();
        }
        RequestAuctionResponseDTO requestAuctionResponseDTO = null;
        try {
            requestAuctionResponseDTO = new ObjectMapper().readValue(response.getBody(), RequestAuctionResponseDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return requestAuctionResponseDTO;
    }


    // Implement other auction-related API methods here
}
