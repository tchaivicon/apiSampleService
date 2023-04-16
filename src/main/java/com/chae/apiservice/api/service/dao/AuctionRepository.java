package com.chae.apiservice.api.service.dao;

import com.chae.apiservice.api.dto.Auction;

public interface AuctionRepository {
    Auction findAuctionById(String auctionId);
}
