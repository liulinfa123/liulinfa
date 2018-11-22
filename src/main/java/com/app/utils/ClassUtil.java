package com.app.utils;

import java.lang.reflect.Method;

/**
 * @Author: ben
 * @Date: 2018/11/21 17:04
 */
public class ClassUtil {

    /**
     * 获取方法
     * @param executeObj
     * @param executeMethodName
     * @param parameterTypes
     * @return
     */
    public static Method getMethodByClass(Class executeObj , String executeMethodName, Class[] parameterTypes ){
        Method method = null;
        try {
            method = executeObj.getMethod(executeMethodName, parameterTypes);
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            method = method == null ? executeObj.getDeclaredMethod(executeMethodName, parameterTypes): method;
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            method = method == null ? executeObj.getSuperclass().getDeclaredMethod(executeMethodName, parameterTypes): method;
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            method = method == null ? executeObj.getSuperclass().getMethod(executeMethodName, parameterTypes): method;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return method;
    }

}
