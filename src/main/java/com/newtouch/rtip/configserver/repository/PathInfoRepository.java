package com.newtouch.rtip.configserver.repository;

import com.newtouch.rtip.configserver.entity.PathInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface PathInfoRepository extends JpaRepository<PathInfo, Long> {
    List<PathInfo> findAll();
}