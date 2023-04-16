package com.chae.apiservice.api.service.message.messages.message;

import com.chae.apiservice.api.dto.Auction;
import com.chae.apiservice.api.service.message.dto.MessageRequest;
import com.chae.apiservice.api.service.message.enumeration.MessageTypeEnumeration;
import com.chae.apiservice.api.service.message.service.Message;
import com.chae.apiservice.api.service.dao.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuctionAcceptedPushMessage implements Message {
    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionAcceptedPushMessage(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public MessageTypeEnumeration getMessageType() {
        return MessageTypeEnumeration.AUCTION_ACCEPTED_PUSH_MESSAGE;
    }


    @Override
    public boolean shouldSendMessage(MessageRequest messageRequest) {
        boolean send = false;
        Auction auction = auctionRepository.findAuctionById(messageRequest.getAuctionId());
        if(auction.getBiddingId().equals("")||null == auction.getBiddingId()){
            send = true;
        }
        return send;
    }

    @Override
    public String getTitle() {
        return "auction accepted!";
    }

    @Override
    public String getContent() {
        return "auctionAccepted Content!";
    }

    @Override
    public String getMethod() {
        return "PUSH";
    }

    @Override
    public String getTemplateId() {
        return null;
    }


}
