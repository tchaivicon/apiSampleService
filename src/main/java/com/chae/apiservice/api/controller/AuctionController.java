package com.chae.apiservice.api.controller;

import com.chae.apiservice.api.dto.RequestAuctionDTO;
import com.chae.apiservice.api.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.service.AuctionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionApiService auctionApiService;

    @Autowired
    public AuctionController(AuctionApiService auctionApiService) {
        this.auctionApiService = auctionApiService;
    }

    @PostMapping("/{auctionId}")
    public ResponseEntity<RequestAuctionResponseDTO> requestAuction(
            @PathVariable String auctionId,
            @RequestBody RequestAuctionDTO requestAuctionDTO) {
        RequestAuctionResponseDTO response = auctionApiService.requestAuction(auctionId, requestAuctionDTO);
        return ResponseEntity.ok(response);
    }

    // Implement other endpoints related to auctions here
}