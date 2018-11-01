package com.app.exception;

import com.app.utils.ResultEnum;
import com.app.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    public ResponseMessage handel(Exception e){
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(),myException.getErrorMsg());
        }else {
            logger.error("系统异常",e);
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }


    }


}
