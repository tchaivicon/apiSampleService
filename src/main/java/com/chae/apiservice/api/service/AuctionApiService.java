package com.chae.apiservice.api.service;

import com.chae.apiservice.api.dto.RequestAuctionDTO;
import com.chae.apiservice.api.dto.RequestAuctionResponseDTO;

public interface AuctionApiService extends BaseApiService{
    RequestAuctionResponseDTO requestAuction(String auctionId, RequestAuctionDTO request);
    // Define other auction-related API methods here
}
