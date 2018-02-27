package com.newtouch.rtip.configserver.repository;

import com.newtouch.rtip.configserver.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long> {
    List<RoleInfo> findAll();
}