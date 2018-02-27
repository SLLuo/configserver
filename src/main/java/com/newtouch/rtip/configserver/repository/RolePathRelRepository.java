package com.newtouch.rtip.configserver.repository;

import com.newtouch.rtip.configserver.entity.PathInfo;
import com.newtouch.rtip.configserver.entity.RolePathRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface RolePathRelRepository extends JpaRepository<RolePathRel, Long> {
    List<PathInfo> findPathInfoByRoleInfoIdIn(Set<Long> roleIds);
}