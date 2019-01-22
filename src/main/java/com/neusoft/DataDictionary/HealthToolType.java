package com.neusoft.DataDictionary;

/***
 * 健康工具类型
 * 2019/1/22
 */
public enum HealthToolType {

    BMI("000300000010", "BMI计算器"),
    ENERGY_REQ_DAY("000300000020", "每日能量需求"),
    DBW("000300000030", "理想体重"),
    WHR("000300000040", "腰臀比");
    private String code;
    private String name;

    private HealthToolType(String code, String name) {
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
