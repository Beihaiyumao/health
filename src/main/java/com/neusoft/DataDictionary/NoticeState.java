package com.neusoft.DataDictionary;

/**
 * 用户通知状态数据字典
 */
public enum NoticeState {
    YES_STATE("000500000010", "开启"),
    NOT_STATE("000500000020", "关闭");
    private String code;
    private String name;

    NoticeState(String code, String name) {
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
