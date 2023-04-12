package com.chae.apiservice.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class RequestAuctionResponseDTO {
    private String auctionId;
    private String auctionProduct;
    private String sellerName;
    private String initialPrice;

    public RequestAuctionResponseDTO(String auctionId, String product_a, String seller_a, String s) {
    }

    // Getters, setters, constructor, and other methods
}
