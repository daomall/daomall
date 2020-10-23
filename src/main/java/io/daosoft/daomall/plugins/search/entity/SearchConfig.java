package io.daosoft.daomall.plugins.search.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SearchConfig {

    @Id
    private Long id;
}
