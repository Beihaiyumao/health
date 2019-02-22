package com.neusoft.DataDictionary;

/**
 * 选项类型
 * 2019/2/21
 */
public enum OptionType {

    SINGLE_ELECTION("000400000010", "单选"),
    MULTIPLE_SELECTIO("000400000020", "多选");
    private String code;
    private String name;

    private OptionType(String code, String name) {
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
