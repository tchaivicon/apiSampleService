package com.chae.apiservice.api.auction.service.impl;

import com.chae.apiservice.api.auction.service.BiddingApiService;
import com.chae.apiservice.api.auction.enumeration.ApiEndpointEnumeration;
import com.chae.apiservice.api.auction.service.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

public class BiddingApiServiceImpl implements BiddingApiService {

    private RestClient restClient;

    @Autowired
    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void selectAuction(String auctionId, String biddingId) {
        String url = ApiEndpointEnumeration.SELECT_AUCTION.getUrlTemplate()
                .replace("{auctionId}", auctionId)
                .replace("{biddingId}", biddingId);
        HttpMethod httpMethod = ApiEndpointEnumeration.SELECT_AUCTION.getHttpMethod();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = restClient.callApi(url, httpMethod, null, headers);
        // Process the response
        if(response.getStatusCode()!= HttpStatus.OK){
            throw new RuntimeException();
        }
    }

    // Implement other bidding-related API methods here

}
