package com.chae.apiservice.message.service.temp;

import com.chae.apiservice.api.auction.dto.Auction;
import com.chae.apiservice.api.auction.service.dao.AuctionRepository;
import org.springframework.stereotype.Component;

@Component
public class AuctionRepositoryTemp implements AuctionRepository {
    @Override
    public Auction findAuctionById(String auctionId) {
        Auction auction = new Auction();
        auction.setId(auctionId);
        return auction;
    }
}
