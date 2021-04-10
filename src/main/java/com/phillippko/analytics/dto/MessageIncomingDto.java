package com.phillippko.analytics.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MessageIncomingDto {
    private String templateId;
    private List<Map<String, String>> variables;


}
