package com.newtouch.rtip.configserver.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/20.
 */
@Entity
public class PathInfo {

    @Id
    @GeneratedValue
    private Long id;
    //父节点id
    private Long pid;
    //权限名称
    private String name;
    //授权链接
    private String path;
    //授权链接
    private String sign;
    //权限描述
    private String remark;

    @OneToMany(mappedBy = "pathInfo")
    private Set<RolePathRel> rolePathRels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<RolePathRel> getRolePathRels() {
        return rolePathRels;
    }

    public void setRolePathRels(Set<RolePathRel> rolePathRels) {
        this.rolePathRels = rolePathRels;
    }
}