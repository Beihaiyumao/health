package com.neusoft.entity;

import java.util.Date;

/**
 * 一级菜单
 * 2019/3/4
 */
public class FirstMenu {

    private String firstMenuId; //id

    private String navBarId;//导航栏id

    private String firstMenuName; //菜单名字

    private Date createTime; //创建时间

    private int sortId; //排序id

    public String getFirstMenuId() {
        return firstMenuId;
    }

    public void setFirstMenuId(String firstMenuId) {
        this.firstMenuId = firstMenuId == null ? null : firstMenuId.trim();
    }

    public String getNavBarId() {
        return navBarId;
    }

    public void setNavBarId(String navBarId) {
        this.navBarId = navBarId == null ? null : navBarId.trim();
    }

    public String getFirstMenuName() {
        return firstMenuName;
    }

    public void setFirstMenuName(String firstMenuName) {
        this.firstMenuName = firstMenuName == null ? null : firstMenuName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }
}