package com.chae.apiservice.api.auction.service;

import com.chae.apiservice.api.auction.dto.Auction;
import com.chae.apiservice.api.auction.dto.RequestAuctionDTO;
import com.chae.apiservice.api.auction.dto.RequestAuctionResponseDTO;

public interface AuctionService {
    public RequestAuctionResponseDTO requestAuction(RequestAuctionDTO requestAuctionDTO);
    public void startAuction(String auctionId);

    Auction getAuction(String auctionId);
}
