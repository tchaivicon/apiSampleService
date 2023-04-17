package com.chae.apiservice.message.service.factory;

import com.chae.apiservice.message.dto.MessageRequest;
import com.chae.apiservice.message.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageFactory {
    private final List<Message> messages;

    @Autowired
    public MessageFactory(List<Message> messages) {
        this.messages = messages;
    }

    public Message getMessage(MessageRequest messageRequest) {
        return messages.stream()
                .filter(message -> messageRequest.getMessageTypeEnumeration().equals(message.getMessageType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported type: " + messageRequest.getMessageTypeEnumeration()));
    }
}
