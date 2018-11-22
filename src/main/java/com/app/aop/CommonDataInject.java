package com.app.aop;

import com.app.utils.ClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: ben
 * @Date: 2018/11/21 16:38
 */

@Aspect
@Component
@Slf4j
public class CommonDataInject {

    private final static String UPDATEMETHOD = "update";

    private final static String INSERTMETHOD = "insert";


    @Pointcut("execution(* com.app.*.dao.*Dao.insert*(..))")
    private void insertCutMethod(){


    }
    @Pointcut("execution(* com.app.*.dao.*Dao.update*(..))")
    private void updateCutMethod(){


    }

    @Around("insertCutMethod()")
    private Object doInsertAround(ProceedingJoinPoint point) throws Throwable {
        Object o = null;
        saveUpdateDate(point, INSERTMETHOD);
        o = point.proceed();
        return o;
    }

    @Around("updateCutMethod()")
    public Object doupdateAround(ProceedingJoinPoint point) throws Throwable {
        Object o = null;
        saveUpdateDate(point, UPDATEMETHOD);
        o = point.proceed();
        return o;
    }


    private Object[] saveUpdateDate(ProceedingJoinPoint point,String method) throws Throwable {

        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        String methods = signature.getName();
        if (!methods.startsWith(method)) {
            return args;
        }else {
            Object saveObj = args[0];
            log.info(saveObj.getClass().getSuperclass().getName());
            if (saveObj.getClass().getSuperclass().getName().endsWith("ParentModel")) {
                //单个保存
                setDate(saveObj);
            } else {
                Iterable<Object> its = (Iterable<Object>)saveObj;
                for (Object data:its) {
                    setDate(data);
                }
            }
        }
        return args;
    }


    private void setDate(Object object){
        try {
            Method method =  ClassUtil.getMethodByClass(object.getClass(),"setUpdateDate",new Class[]{long.class});
            method.invoke(object,System.currentTimeMillis());
        }catch (Exception e){
        }

    }



}
