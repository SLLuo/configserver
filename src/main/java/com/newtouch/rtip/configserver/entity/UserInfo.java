package com.newtouch.rtip.configserver.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/20.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;
    private Short type;
    private Short status;
    private String name;
    private String remark;
    private String username;
    private String password;

    @OneToMany(mappedBy = "userInfo")
    private Set<UserRoleRel> userRoleRels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRoleRel> getUserRoleRels() {
        return userRoleRels;
    }

    public void setUserRoleRels(Set<UserRoleRel> userRoleRels) {
        this.userRoleRels = userRoleRels;
    }
}