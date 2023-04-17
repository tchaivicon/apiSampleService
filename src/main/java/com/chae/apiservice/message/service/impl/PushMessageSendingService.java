package com.chae.apiservice.message.service.impl;

import com.chae.apiservice.message.service.Message;
import com.chae.apiservice.message.service.MessageSendingService;
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
