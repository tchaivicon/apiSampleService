package com.chae.apiservice.scheduler.service.dao;

import com.chae.apiservice.api.service.message.dto.MessageRequest;
import com.chae.apiservice.api.service.message.enumeration.MessageTypeEnumeration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledMessageRepositoryImpl implements ScheduledMessageRepository{
    @Override
    public List<MessageRequest> findDueMessages() {
        List<MessageRequest> messageRequests = new ArrayList<>();
        MessageRequest messageRequest1 = new MessageRequest("0001",MessageTypeEnumeration.VERIFY_AUCTION_KAKAO_MESSAGE);
        MessageRequest messageRequest2 = new MessageRequest("0002",MessageTypeEnumeration.AUCTION_ACCEPTED_PUSH_MESSAGE);
        messageRequests.add(messageRequest1);
        messageRequests.add(messageRequest2);
        return messageRequests;
    }
}
