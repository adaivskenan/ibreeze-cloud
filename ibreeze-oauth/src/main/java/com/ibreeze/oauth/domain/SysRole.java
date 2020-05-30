package com.ibreeze.oauth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by adaivskenan on 2020/5/29.
 */
public class SysRole  implements GrantedAuthority{

    private Integer id;

    private String roleName;

    private String roleDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }



    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
