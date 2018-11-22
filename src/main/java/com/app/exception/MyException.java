package com.app.exception;

import com.app.utils.ResultEnum;

public class MyException extends RuntimeException {

    private int code;

    private String errorMsg;

    public MyException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.errorMsg = resultEnum.getMsg();
    }

    public MyException(int code,String errorMsg){
        this.code = code;
        this.errorMsg = errorMsg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
