package com.newtouch.rtip.configserver.repository;

import com.newtouch.rtip.configserver.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);

    @Query("select o from UserInfo o where o.name like %?1% or o.username like %?1% or o.remark like %?1%")
    Page<UserInfo> findByTextContaining(String text, Pageable pageable);
}
