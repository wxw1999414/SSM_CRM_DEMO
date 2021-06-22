package com.yc137.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 人员表
 */

public class TUser implements Serializable {
    private Integer rid;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 姓名
     */
    private String uName;

    /**
     * 职务
     */
    private String uPost;

    /**
     * 联系电话
     */
    private String uPhone;

    private Integer uParentId;

    /**
     * 部门ID
     */
    private Integer uStorageId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 备注
     */
    private String uRemark;

    /**
     * 用户角色
     */
    private List<TRole> tRole;


    private static final long serialVersionUID = 1L;

    public List<TRole> gettRole() {
        return tRole;
    }

    public void settRole(List<TRole> tRole) {
        this.tRole = tRole;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPost() {
        return uPost;
    }

    public void setuPost(String uPost) {
        this.uPost = uPost;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public Integer getuParentId() {
        return uParentId;
    }

    public void setuParentId(Integer uParentId) {
        this.uParentId = uParentId;
    }

    public Integer getuStorageId() {
        return uStorageId;
    }

    public void setuStorageId(Integer uStorageId) {
        this.uStorageId = uStorageId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getuRemark() {
        return uRemark;
    }

    public void setuRemark(String uRemark) {
        this.uRemark = uRemark;
    }

    public TUser() {
    }

    public TUser(String loginName, String password, String uName, String uPost, String uPhone, Integer uParentId, Integer uStorageId, Integer status, Date createTime, String uRemark, List<TRole> tRole) {
        this.loginName = loginName;
        this.password = password;
        this.uName = uName;
        this.uPost = uPost;
        this.uPhone = uPhone;
        this.uParentId = uParentId;
        this.uStorageId = uStorageId;
        this.status = status;
        this.createTime = createTime;
        this.uRemark = uRemark;
        this.tRole = tRole;
    }

    public TUser(Integer rid, String loginName, String password, String uName, String uPost, String uPhone, Integer uParentId, Integer uStorageId, Integer status, Date createTime, String uRemark, List<TRole> tRole) {
        this.rid = rid;
        this.loginName = loginName;
        this.password = password;
        this.uName = uName;
        this.uPost = uPost;
        this.uPhone = uPhone;
        this.uParentId = uParentId;
        this.uStorageId = uStorageId;
        this.status = status;
        this.createTime = createTime;
        this.uRemark = uRemark;
        this.tRole = tRole;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "rid=" + rid +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", uName='" + uName + '\'' +
                ", uPost='" + uPost + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uParentId=" + uParentId +
                ", uStorageId=" + uStorageId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", uRemark='" + uRemark + '\'' +
                ", tRole=" + tRole +
                '}';
    }
}