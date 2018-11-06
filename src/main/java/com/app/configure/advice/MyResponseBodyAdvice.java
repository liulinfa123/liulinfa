package com.app.configure.advice;


import com.app.configure.SensitivityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/**
 * Controller Response 统一敏感数据解密
 * Create By liulinfa
 */
@Slf4j
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Autowired
    private SensitivityProperties sensitivityProperties;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    private String[] decodeFields = {};

    private String[] undecodeFields = {};


    /**
     *   所有的方法都需要拦截
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     *  对数据进行加密 跟解密
     * @param result
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object result, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (result == null) {
            return null;
        }
        Boolean enable = sensitivityProperties.getEnable();
        if (null == enable || !enable) {
            return result;
        }
        // 加密
        List<String> encryptApiField = sensitivityProperties.getEncryptApiField();
        // 解密
        List<String> decryptApiField = sensitivityProperties.getDecryptApiField();

        SecretField serializedField = methodParameter.getMethodAnnotation(SecretField.class);


        return null;
    }
}
