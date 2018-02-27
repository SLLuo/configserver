package com.newtouch.rtip.configserver.service;

import com.newtouch.rtip.configserver.entity.UserInfo;
import com.newtouch.rtip.configserver.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    public Page<UserInfo> findByTextContaining(
            String text, int page, int size, String order, String prop) {
        PageRequest pageable = new PageRequest(page, size,
                "DESC".equals(order) ? Sort.Direction.DESC : Sort.Direction.ASC, prop);
        return userInfoRepository.findByTextContaining(text, pageable);
    }
}
