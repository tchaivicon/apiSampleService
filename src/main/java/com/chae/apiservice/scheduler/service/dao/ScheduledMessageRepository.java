package com.chae.apiservice.scheduler.service.dao;

import com.chae.apiservice.message.dto.MessageRequest;

import java.util.List;

public interface ScheduledMessageRepository {
    List<MessageRequest> findDueMessages();

}
