package com.chae.apiservice.api.auction.service;

import com.chae.apiservice.api.auction.dto.RequestAuctionDTO;
import com.chae.apiservice.api.auction.dto.RequestAuctionResponseDTO;

public interface AuctionApiService extends BaseApiService{
    RequestAuctionResponseDTO requestAuction(String auctionId, RequestAuctionDTO request);
    // Define other auction-related API methods here
}
