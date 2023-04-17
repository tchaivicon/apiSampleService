package com.chae.apiservice.message.service;

import com.chae.apiservice.message.dto.MessageRequest;
import com.chae.apiservice.message.enumeration.MessageTypeEnumeration;

public interface Message {
    MessageTypeEnumeration getMessageType();

    boolean shouldSendMessage(MessageRequest messageRequest);

    String getTitle();

    String getContent();

    String getMethod();

    String getTemplateId();

}
