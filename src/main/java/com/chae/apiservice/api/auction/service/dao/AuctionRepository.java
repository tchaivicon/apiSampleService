package com.chae.apiservice.api.auction.service.dao;

import com.chae.apiservice.api.auction.dto.Auction;

public interface AuctionRepository {
    Auction findAuctionById(String auctionId);
}
