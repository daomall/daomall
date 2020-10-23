package io.daosoft.daomall.plugins.wechat.repository;

import io.daosoft.daomall.plugins.wechat.entity.SearchConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WechatConfigRepository extends JpaRepository<SearchConfig, Long> {
}
