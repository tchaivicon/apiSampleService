package com.chae.apiservice.scheduler.service.dao;

import com.chae.apiservice.api.service.message.dto.MessageRequest;

import java.util.List;

public interface ScheduledMessageRepository {
    List<MessageRequest> findDueMessages();

}
