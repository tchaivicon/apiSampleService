package com.chae.apiservice.message.messages.message;

import com.chae.apiservice.api.auction.dto.Auction;
import com.chae.apiservice.message.dto.MessageRequest;
import com.chae.apiservice.message.enumeration.MessageTypeEnumeration;
import com.chae.apiservice.message.service.Message;
import com.chae.apiservice.api.auction.service.dao.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifyAuctionKakaoMessage implements Message {
    private final AuctionRepository auctionRepository;

    @Autowired
    public VerifyAuctionKakaoMessage(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public MessageTypeEnumeration getMessageType() {
        return MessageTypeEnumeration.VERIFY_AUCTION_KAKAO_MESSAGE;
    }


    @Override
    public boolean shouldSendMessage(MessageRequest messageRequest) {
        boolean send = false;
        Auction auction = auctionRepository.findAuctionById(messageRequest.getAuctionId());
        if(auction.isBankRegistered() == false){
            send = true;
        }
        return send;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getContent() {
        return "you gotta verify this auction mate";
    }

    @Override
    public String getMethod() {
        return "KAKAO";
    }

    @Override
    public String getTemplateId() {
        return "templateidVerifyAuctionKakaoMessage";
    }

}
