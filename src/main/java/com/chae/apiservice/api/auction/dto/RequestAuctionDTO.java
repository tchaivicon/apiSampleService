package com.chae.apiservice.api.auction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestAuctionDTO {
    private String auctionProduct;
    private String sellerName;
    private String initialPrice;

    public RequestAuctionDTO(String auctionProduct, String sellerName, String initialPrice) {
    }

    // Getters, setters, constructor, and other methods
}
