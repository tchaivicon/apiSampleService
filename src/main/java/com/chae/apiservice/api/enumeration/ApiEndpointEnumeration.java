package com.chae.apiservice.api.enumeration;

import org.springframework.http.HttpMethod;

public enum ApiEndpointEnumeration {
    REQUEST_AUCTION("https://api.com/api/v1/auctions/{auctionId}", HttpMethod.POST),
    SELECT_AUCTION("https://api.com/api/v1/auctions/{auctionId}/biddings/{biddingId}", HttpMethod.POST);

    private final String urlTemplate;
    private final HttpMethod httpMethod;

    ApiEndpointEnumeration(String urlTemplate, HttpMethod httpMethod) {
        this.urlTemplate = urlTemplate;
        this.httpMethod = httpMethod;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}