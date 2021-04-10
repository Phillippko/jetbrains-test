package com.phillippko.analytics.service;

import com.phillippko.analytics.dto.MessageIncomingDto;

public interface MessageService {
    void sendMessage(MessageIncomingDto messageIncomingDto);
}
