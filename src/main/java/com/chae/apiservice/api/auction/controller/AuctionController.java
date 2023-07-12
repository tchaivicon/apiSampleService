package com.chae.apiservice.api.auction.controller;

import com.chae.apiservice.api.auction.dto.Auction;
import com.chae.apiservice.api.auction.dto.RequestAuctionDTO;
import com.chae.apiservice.api.auction.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.auction.service.AuctionService;
import com.chae.apiservice.message.dto.MessageRequest;
import com.chae.apiservice.message.enumeration.MessageTypeEnumeration;
import com.chae.apiservice.message.service.MessageService;
import com.chae.apiservice.message.service.factory.MessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionService auctionService;
    private final MessageFactory messageFactory;
    private final MessageService messageService;

    @Autowired
    public AuctionController(AuctionService auctionService, MessageFactory messageFactory, MessageService messageService) {
        this.auctionService = auctionService;
        this.messageFactory = messageFactory;
        this.messageService = messageService;
    }

    @PostMapping("/v1/auctions")
    public ResponseEntity<RequestAuctionResponseDTO> requestAuction(
            @RequestBody RequestAuctionDTO requestAuctionDTO) {
        RequestAuctionResponseDTO response = auctionService.requestAuction(requestAuctionDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/v1/auctions/{auctionId}:start")
    public ResponseEntity<Auction> startAuction(
            @PathVariable String auctionId) {
        auctionService.startAuction(auctionId);
        Auction auction = auctionService.getAuction(auctionId);
        MessageRequest messageRequest = new MessageRequest(auctionId, MessageTypeEnumeration.AUCTION_STARTED_PUSH_MESSAGE);
        messageService.sendMessage(messageFactory.getMessage(messageRequest));

        return ResponseEntity.ok(auction);
    }
    // Implement other endpoints related to auctions here


}