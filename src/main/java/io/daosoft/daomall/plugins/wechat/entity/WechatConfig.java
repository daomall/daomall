package io.daosoft.daomall.plugins.wechat.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class WechatConfig {

    @Id
    private Long id;
}
