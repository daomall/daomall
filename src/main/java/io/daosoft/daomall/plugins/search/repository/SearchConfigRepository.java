package io.daosoft.daomall.plugins.search.repository;

import io.daosoft.daomall.plugins.wechat.entity.SearchConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchConfigRepository extends JpaRepository<SearchConfig, Long> {
}
