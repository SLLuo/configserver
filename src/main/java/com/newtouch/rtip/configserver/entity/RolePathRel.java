package com.newtouch.rtip.configserver.entity;

import javax.persistence.*;

/**
 * Created by yangyibo on 17/1/20.
 */
@Entity
public class RolePathRel {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private RoleInfo roleInfo;
    @ManyToOne(fetch = FetchType.EAGER)
    private PathInfo pathInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    public PathInfo getPathInfo() {
        return pathInfo;
    }

    public void setPathInfo(PathInfo pathInfo) {
        this.pathInfo = pathInfo;
    }
}