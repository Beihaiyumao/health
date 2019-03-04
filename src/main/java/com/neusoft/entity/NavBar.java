package com.neusoft.entity;

import java.util.Date;

/**
 * 导航栏
 * 2019/3/3
 */
public class NavBar {
    private String navBarId; //id

    private String navBarName; //导航名称

    private Date createTime; //创建时间

    private int sortId; //排序id

    public String getNavBarId() {
        return navBarId;
    }

    public void setNavBarId(String navBarId) {
        this.navBarId = navBarId == null ? null : navBarId.trim();
    }

    public String getNavBarName() {
        return navBarName;
    }

    public void setNavBarName(String navBarName) {
        this.navBarName = navBarName == null ? null : navBarName.trim();
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