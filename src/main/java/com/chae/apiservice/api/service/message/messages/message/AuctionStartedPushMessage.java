package com.chae.apiservice.api.service.message.messages.message;

import com.chae.apiservice.api.service.message.dto.MessageRequest;
import com.chae.apiservice.api.service.message.enumeration.MessageTypeEnumeration;
import com.chae.apiservice.api.service.message.service.Message;
import org.springframework.stereotype.Component;

@Component
public class AuctionStartedPushMessage implements Message {

    @Override
    public MessageTypeEnumeration getMessageType() {
        return MessageTypeEnumeration.AUCTION_STARTED_PUSH_MESSAGE;
    }



    @Override
    public boolean shouldSendMessage(MessageRequest messageRequest) {
        return true;
    }

    @Override
    public String getTitle() {
        return "auctionStartedPushMessageTitle";
    }

    @Override
    public String getContent() {
        return "auctionStartedPushMessageContents!!!";
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
