package com.chae.apiservice.api.service.message.dto;

import com.chae.apiservice.api.service.message.enumeration.MessageTypeEnumeration;

import java.time.LocalDateTime;

public class MessageRequest {
    private String messageId;
    private String auctionId;
    private MessageTypeEnumeration messageTypeEnumeration;
    private LocalDateTime scheduledSendTime;

    public MessageRequest(String auctionId, MessageTypeEnumeration messageTypeEnumeration) {
        this.auctionId = auctionId;
        this.messageTypeEnumeration = messageTypeEnumeration;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public MessageTypeEnumeration getMessageTypeEnumeration() {
        return messageTypeEnumeration;
    }

    public void setMessageTypeEnumeration(MessageTypeEnumeration messageTypeEnumeration) {
        this.messageTypeEnumeration = messageTypeEnumeration;
    }

    public LocalDateTime getScheduledSendTime() {
        return scheduledSendTime;
    }

    public void setScheduledSendTime(LocalDateTime scheduledSendTime) {
        this.scheduledSendTime = scheduledSendTime;
    }
}
