package com.newtouch.rtip.configserver.web;

import com.newtouch.rtip.configserver.entity.UserInfo;
import com.newtouch.rtip.configserver.repository.UserInfoRepository;
import com.newtouch.rtip.configserver.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserInfoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);


    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserInfo save(UserInfo userInfo) throws Exception {
        return userInfoRepository.save(userInfo);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public boolean save(@PathVariable Long id) throws Exception {
        userInfoRepository.delete(id);
        return true;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Page<UserInfo> findByTextContaining(
            String text, int page, int size, String order, String prop) throws Exception {
        return userInfoService.findByTextContaining(text, page, size, order, prop);
    }
}
