package com.chae.apiservice.api.service.message.service.impl;

import com.chae.apiservice.api.service.message.service.Message;
import com.chae.apiservice.api.service.message.service.MessageSendingService;
import org.springframework.stereotype.Component;

@Component("PushMessageSendingService")
public class PushMessageSendingService implements MessageSendingService {


    @Override
    public boolean supports(String method) {
        return "PUSH".equals(method);
    }

    @Override
    public void send(Message message) {

    }
}
