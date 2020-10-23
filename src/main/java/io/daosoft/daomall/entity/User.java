package io.daosoft.daomall.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private Long id;

}
