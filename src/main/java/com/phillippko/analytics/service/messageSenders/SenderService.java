package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.domain.Recipient;
import com.phillippko.analytics.dto.MessageOutgoingDto;

import java.util.List;

public interface SenderService {
    void sendMessage(MessageOutgoingDto messageIncomingDto, List<Recipient> recipients);
}
