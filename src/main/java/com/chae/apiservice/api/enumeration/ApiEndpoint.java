package com.chae.apiservice.api.enumeration;

import org.springframework.http.HttpMethod;

public enum ApiEndpoint {
    REQUEST_AUCTION("https://api.com/v1/auction/{auctionId}", HttpMethod.POST),
    SELECT_AUCTION("https://api.com/v1/auction/{auctionId}/biddings/{biddingId}", HttpMethod.POST);

    private final String urlTemplate;
    private final HttpMethod httpMethod;

    ApiEndpoint(String urlTemplate, HttpMethod httpMethod) {
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