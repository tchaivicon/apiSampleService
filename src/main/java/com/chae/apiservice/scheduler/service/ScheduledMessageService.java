package com.chae.apiservice.scheduler.service;

import com.chae.apiservice.api.service.message.dto.MessageRequest;
import com.chae.apiservice.api.service.message.service.Message;
import com.chae.apiservice.api.service.message.service.MessageService;
import com.chae.apiservice.api.service.message.service.factory.MessageFactory;
import com.chae.apiservice.scheduler.service.dao.ScheduledMessageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledMessageService {
    private final ScheduledMessageRepository scheduledMessageRepository;
    private final MessageFactory messageFactory;
    private final MessageService messageService;

    public ScheduledMessageService(ScheduledMessageRepository scheduledMessageRepository, MessageFactory messageFactory, MessageService messageService) {
        this.scheduledMessageRepository = scheduledMessageRepository;
        this.messageFactory = messageFactory;
        this.messageService = messageService;
    }

    //@Scheduled(fixedRate = 600000) // Run every 10 minutes
    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void processScheduledMessages() {
        List<MessageRequest> scheduledMessageRequests = scheduledMessageRepository.findDueMessages();

        for (MessageRequest messageRequest : scheduledMessageRequests) {
            Message message = messageFactory.getMessage(messageRequest);
            if (message.shouldSendMessage(messageRequest)) {
                messageService.sendMessage(message);
            }
        }
    }
}