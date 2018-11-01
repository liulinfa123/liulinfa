package com.app.utils;

import com.app.exception.ResponseMessage;

public class ResultUtil {


    /**
     *  成功的时候返回的消息
     * @param object
     * @return
     */
    public static ResponseMessage success(Object object){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(ResultEnum.SUCCESS.getCode());
        responseMessage.setMsg(ResultEnum.SUCCESS.getMsg());
        responseMessage.setData(object);
        return responseMessage;
    }

    /**
     * 操作成功不返回消息
     * @return
     */
    public static ResponseMessage success(){
        return success(null);
    }

    /**
     *  操作失败返回的信息
     * @param code
     * @param msg
     * @return
     */
    public static ResponseMessage error(int code,String msg){

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(code);
        responseMessage.setMsg(msg);
        return responseMessage;
    }

    /**
     *  操作失败返回的信息
     * @param resultEnum
     * @return
     */
    public static ResponseMessage error(ResultEnum resultEnum){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(resultEnum.getCode());
        responseMessage.setMsg(resultEnum.getMsg());
        return responseMessage;
    }




}
