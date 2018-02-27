package com.newtouch.rtip.configserver.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/20.
 */
@Entity
public class RoleInfo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String remark;

    @OneToMany(mappedBy = "roleInfo")
    private Set<UserRoleRel> userRoleRels;

    @OneToMany(mappedBy = "roleInfo")
    private Set<RolePathRel> rolePathRels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<UserRoleRel> getUserRoleRels() {
        return userRoleRels;
    }

    public void setUserRoleRels(Set<UserRoleRel> userRoleRels) {
        this.userRoleRels = userRoleRels;
    }

    public Set<RolePathRel> getRolePathRels() {
        return rolePathRels;
    }

    public void setRolePathRels(Set<RolePathRel> rolePathRels) {
        this.rolePathRels = rolePathRels;
    }
}