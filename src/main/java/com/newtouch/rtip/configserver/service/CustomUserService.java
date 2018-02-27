package com.newtouch.rtip.configserver.service;

import com.newtouch.rtip.configserver.entity.PathInfo;
import com.newtouch.rtip.configserver.entity.UserInfo;
import com.newtouch.rtip.configserver.entity.UserRoleRel;
import com.newtouch.rtip.configserver.repository.PathInfoRepository;
import com.newtouch.rtip.configserver.repository.RolePathRelRepository;
import com.newtouch.rtip.configserver.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    RolePathRelRepository rolePathRelRepository;
    @Autowired
    PathInfoRepository pathInfoRepository;

    public UserDetails loadUserByUsername(String username) {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        if (userInfo != null) {
            Set<Long> roleIds = new HashSet<>();
            for (UserRoleRel userRoleRel : userInfo.getUserRoleRels()) {
                roleIds.add(userRoleRel.getRoleInfo().getId());
            }
            List<PathInfo> pathInfos = rolePathRelRepository.findPathInfoByRoleInfoIdIn(roleIds);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (PathInfo pathInfo : pathInfos) {
                if (pathInfo != null && pathInfo.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(pathInfo.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(userInfo.getUsername(), userInfo.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}