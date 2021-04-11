package com.phillippko.analytics.service.messageSenders;

import com.phillippko.analytics.dto.MessageOutgoingDto;
import feign.Response;

import java.util.List;

public interface SenderService {
    List<Response> sendMessage(MessageOutgoingDto messageIncomingDto);
}
