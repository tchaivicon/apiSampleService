package com.chae.apiservice.api.auction.service.impl;

import com.chae.apiservice.api.auction.service.AuctionService;
import com.chae.apiservice.api.auction.dto.Auction;
import com.chae.apiservice.api.auction.dto.RequestAuctionDTO;
import com.chae.apiservice.api.auction.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.auction.service.AuctionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService {
    AuctionApiService auctionApiService;
    @Autowired
    public AuctionServiceImpl(AuctionApiService auctionApiService) {
        this.auctionApiService = auctionApiService;
    }

    @Override
    public RequestAuctionResponseDTO requestAuction(RequestAuctionDTO requestAuctionDTO) {
        return auctionApiService.requestAuction("",requestAuctionDTO);
    }

    @Override
    public void startAuction(String auctionId) {
        System.out.println("Start Auction : "+ auctionId);
    }

    @Override
    public Auction getAuction(String auctionId) {
        Auction auction = new Auction();
        auction.setId(auctionId);
        return auction;
    }
}
