package com.phillippko.analytics.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Recipient {
    @Id
    private String Url;
    @ManyToMany
    private List<Template> templates;
}
