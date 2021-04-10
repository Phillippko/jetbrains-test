package com.phillippko.analytics.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Template {
    @Id
    private String templateId;
    private String template;
    @ManyToMany
    private List<Recipient> recipients;
}
