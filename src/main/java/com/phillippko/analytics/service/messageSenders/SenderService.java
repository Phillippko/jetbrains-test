package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.dto.MessageOutgoingDto;

import java.util.List;

public interface SenderService {
    List<String> sendMessage(MessageOutgoingDto messageIncomingDto);
}
