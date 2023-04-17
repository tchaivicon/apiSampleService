package com.chae.apiservice.message.messages.message;

import com.chae.apiservice.message.dto.MessageRequest;
import com.chae.apiservice.message.enumeration.MessageTypeEnumeration;
import com.chae.apiservice.message.service.Message;
import org.springframework.stereotype.Component;

@Component
public class AuctionBidFailedKakaoMessage implements Message {

    @Override
    public MessageTypeEnumeration getMessageType() {
        return MessageTypeEnumeration.AUCTION_BID_FAILED_KAKAO_MESSAGE;
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
