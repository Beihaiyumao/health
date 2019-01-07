package com.neusoft.DataDictionary;

/**
 * 是否被拉黑
 * 2018/12/29
 */
public enum BlackState {
    BLACK_STATE_FALSE("000200000010", "未拉黑"),
    BLACK_STATE_TRUE("000200000020", "已拉黑");
    private String code;
    private String name;

    private BlackState(String code, String name) {
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
