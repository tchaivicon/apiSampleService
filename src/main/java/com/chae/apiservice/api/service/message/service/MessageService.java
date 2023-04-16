package com.chae.apiservice.api.service.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final List<MessageSendingService> messageSendingServices;
    @Autowired
    public MessageService(List<MessageSendingService> messageSendingServices) {
        this.messageSendingServices = messageSendingServices;
    }

    public void sendMessage(Message message) {
        // Call the new methods to get the required information
        String method = message.getMethod();
        String templateId = message.getTemplateId();
        String title = message.getTitle();
        String content = message.getContent();
        MessageSendingService messageSendingService = messageSendingServices.stream()
                .filter(service -> service.supports(method))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No suitable message request service found for method: " + method));

        messageSendingService.send(message);
        // Implement the logic to send the message
        // Use the method, templateId, title, and content as needed
    }
}
