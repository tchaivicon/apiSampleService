package com.chae.apiservice.api.service.message.service;

import com.chae.apiservice.api.service.message.dto.MessageRequest;
import com.chae.apiservice.api.service.message.enumeration.MessageTypeEnumeration;

public interface Message {
    MessageTypeEnumeration getMessageType();

    boolean shouldSendMessage(MessageRequest messageRequest);

    String getTitle();

    String getContent();

    String getMethod();

    String getTemplateId();

}
