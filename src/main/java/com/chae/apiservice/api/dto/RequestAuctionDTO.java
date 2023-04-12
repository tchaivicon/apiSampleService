package com.chae.apiservice.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestAuctionDTO {
    private String auctionProduct;
    private String sellerName;
    private String initialPrice;

    public RequestAuctionDTO(String product_a, String seller_a, String s) {
    }

    // Getters, setters, constructor, and other methods
}
