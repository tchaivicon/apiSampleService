package com.chae.apiservice.message.messages.message;

import com.chae.apiservice.message.dto.MessageRequest;
import com.chae.apiservice.message.enumeration.MessageTypeEnumeration;
import com.chae.apiservice.message.service.Message;
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
