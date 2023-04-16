package com.chae.apiservice.api.service.message.service;

public interface MessageSendingService {
    boolean supports(String method);
    void send(Message message);
}
