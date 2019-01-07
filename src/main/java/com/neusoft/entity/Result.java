package com.neusoft.entity;

/**
 * 封装接口返回值
 */
public class Result {

    private int code; //状态码 100:正常,200:错误

    private String msg; //信息

    private boolean isSuccess; //是否成功
    private Object object; //对象

    public Result() {

    }

    public Result(int code, String msg, boolean isSuccess) {
        this.code = code;
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

    public Result(int code, String msg, boolean isSuccess, Object o) {
        this.code = code;
        this.msg = msg;
        this.isSuccess = isSuccess;
        this.object = o;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
