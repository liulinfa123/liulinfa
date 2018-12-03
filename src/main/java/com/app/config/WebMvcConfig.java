package com.app.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author: ben
 * @Date: 2018/11/29 18:23
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> url = Lists.newArrayList();
        url.add("/admin/backstageLogin");
        url.add("/admin/backstageRegister");
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/admin/*").excludePathPatterns(url);
    }
}
