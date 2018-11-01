package com.app.exception;

import lombok.Data;

@Data
public class ResponseMessage<T> {

    private int code;

    private String msg;

    private T data;

}
