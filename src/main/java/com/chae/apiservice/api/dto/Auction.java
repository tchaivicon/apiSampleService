package com.chae.apiservice.api.dto;

import java.time.LocalDateTime;

public class Auction {
    private String id;
    private LocalDateTime requestedTime;
    private LocalDateTime biddingReceivedTime;
    private String biddingId;
    private boolean bankRegistered;

    public boolean isBankRegistered() {
        return bankRegistered;
    }

    public void setBankRegistered(boolean bankRegistered) {
        this.bankRegistered = bankRegistered;
    }

    public LocalDateTime getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(LocalDateTime requestedTime) {
        this.requestedTime = requestedTime;
    }

    public LocalDateTime getBiddingReceivedTime() {
        return biddingReceivedTime;
    }

    public void setBiddingReceivedTime(LocalDateTime biddingReceivedTime) {
        this.biddingReceivedTime = biddingReceivedTime;
    }

    public String getBiddingId() {
        return biddingId;
    }

    public void setBiddingId(String biddingId) {
        this.biddingId = biddingId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
