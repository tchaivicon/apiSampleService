package com.chae.apiservice.api.service;

import com.chae.apiservice.api.dto.Auction;
import com.chae.apiservice.api.dto.RequestAuctionDTO;
import com.chae.apiservice.api.dto.RequestAuctionResponseDTO;

public interface AuctionService {
    public RequestAuctionResponseDTO requestAuction(RequestAuctionDTO requestAuctionDTO);
    public void startAuction(String auctionId);

    Auction getAuction(String auctionId);
}
