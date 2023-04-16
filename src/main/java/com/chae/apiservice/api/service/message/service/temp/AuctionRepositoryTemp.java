package com.chae.apiservice.api.service.message.service.temp;

import com.chae.apiservice.api.dto.Auction;
import com.chae.apiservice.api.service.dao.AuctionRepository;
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
