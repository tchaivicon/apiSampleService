package com.chae.apiservice.message.service;

public interface MessageSendingService {
    boolean supports(String method);
    void send(Message message);
}
