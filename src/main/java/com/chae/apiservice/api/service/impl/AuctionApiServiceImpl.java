package com.chae.apiservice.api.service.impl;

import com.chae.apiservice.api.dto.RequestAuctionDTO;
import com.chae.apiservice.api.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.enumeration.ApiEndpoint;
import com.chae.apiservice.api.service.AuctionApiService;
import com.chae.apiservice.api.service.RestClient;
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
        String url = ApiEndpoint.REQUEST_AUCTION.getUrlTemplate().replace("{auctionId}", auctionId);
        HttpMethod httpMethod = ApiEndpoint.REQUEST_AUCTION.getHttpMethod();
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
