package com.chae.apiservice.api.service.message.messages.message;

import com.chae.apiservice.api.service.message.dto.MessageRequest;
import com.chae.apiservice.api.service.message.enumeration.MessageTypeEnumeration;
import com.chae.apiservice.api.service.message.service.Message;
import org.springframework.stereotype.Component;

@Component
public class AuctionBiddingKakaoMessage implements Message {

    @Override
    public MessageTypeEnumeration getMessageType() {
        return MessageTypeEnumeration.AUCTION_BIDDING_KAKAO_MESSAGE;
    }


    @Override
    public boolean shouldSendMessage(MessageRequest messageRequest) {
        return true;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public String getMethod() {
        return "KAKAO";
    }

    @Override
    public String getTemplateId() {
        return null;
    }

}
