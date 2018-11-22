package com.app.utils;

public enum ResultEnum {

    UNKNOWN_ERROR(400,"未知错误"),SUCCESS(200, "success"),SYSTEM_ERROR(1001,"系统错误"),LOGIN_ERROR(400,"帐号或密码错误");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
