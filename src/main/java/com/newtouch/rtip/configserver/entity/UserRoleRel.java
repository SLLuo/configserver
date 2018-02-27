package com.newtouch.rtip.configserver.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/20.
 */
@Entity
public class UserRoleRel {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserInfo userInfo;
    @ManyToOne(fetch = FetchType.EAGER)
    private RoleInfo roleInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
}