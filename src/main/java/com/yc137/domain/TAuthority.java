package com.yc137.domain;

/**
 * 树形菜单
 */
public class TAuthority {
    private static final long serialVersionUID = 1L;
    /**
     * 操作功能ID
     */
    private Long id;

    /**
     * 是否菜单
     */
    private Integer isMenu;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 菜单类型
     */
    private Integer menuType;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 操作URL
     */
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}