package com.yc137.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 角色
 */
public class TRole implements Serializable {
    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;
    /**
     * 当前角色下的用户
     */
    private List<TUser> tUserList;
    /**
     * 当前角色的权限
     */
    private List<TAuthority> authList;

    private static final long serialVersionUID = 1L;

    public List<TAuthority> getAuthList() {
        return authList;
    }

    public void setAuthList(List<TAuthority> authList) {
        this.authList = authList;
    }

    public List<TUser> gettUserList() {
        return tUserList;
    }

    public void settUserList(List<TUser> tUserList) {
        this.tUserList = tUserList;
    }

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

    public TRole() {
    }

    public TRole(String name, List<TUser> tUserList) {
        this.name = name;
        this.tUserList = tUserList;
    }

    public TRole(Long id, String name, List<TUser> tUserList) {
        this.id = id;
        this.name = name;
        this.tUserList = tUserList;
    }

    public TRole(String name, List<TUser> tUserList, List<TAuthority> authList) {
        this.name = name;
        this.tUserList = tUserList;
        this.authList = authList;
    }

    public TRole(Long id, String name, List<TUser> tUserList, List<TAuthority> authList) {
        this.id = id;
        this.name = name;
        this.tUserList = tUserList;
        this.authList = authList;
    }

    @Override
    public String toString() {
        return "TRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tUserList=" + tUserList +
                ", authList=" + authList +
                '}';
    }


}