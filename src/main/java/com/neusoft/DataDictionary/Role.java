package com.neusoft.DataDictionary;

/**
 * 用户角色
 * 2018/12/29
 */
public enum Role {
    USER("000100000010", "普通用户"),
    DOCTOR("000100000020", "医生"),
    ADMIN("000100000030", "管理员");
    private String code;
    private String name;

    Role(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
