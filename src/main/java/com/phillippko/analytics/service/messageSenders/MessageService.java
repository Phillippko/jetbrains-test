package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.dto.MessageIncomingDto;

public interface MessageService {
    void sendMessage(MessageIncomingDto messageIncomingDto);
}
