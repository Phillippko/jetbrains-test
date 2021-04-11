package com.phillippko.analytics.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MessageIncomingDto {
    private final String templateId;
    private final List<Map<String, String>> variables;
}
