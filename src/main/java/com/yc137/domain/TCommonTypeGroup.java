package com.yc137.domain;

/**
 * 通用类型组数据字典
 */
public class TCommonTypeGroup {
    private static final long serialVersionUID = 1L;
    /**
     * 类型组ID
     */
    private Long id;

    /**
     * 类型组名字
     */
    private String groupName;

    /**
     * 类型组标签
     */
    private String groupLabel;

    /**
     * 是否使用
     */
    private Integer enable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLabel() {
        return groupLabel;
    }

    public void setGroupLabel(String groupLabel) {
        this.groupLabel = groupLabel;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}