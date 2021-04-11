package com.phillippko.analytics.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phillippko.analytics.domain.Recipient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MessageOutgoingDto {
    private String message;
    @JsonIgnore
    private List<Recipient> recipients;

}
