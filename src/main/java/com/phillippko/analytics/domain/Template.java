package com.phillippko.analytics.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
public class Template {
    @Id
    private String templateId;
    private String template;
    @ManyToMany
    private List<Recipient> recipients;
}
