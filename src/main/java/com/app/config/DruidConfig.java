package com.app.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ben
 * @Date: 2018/12/20 17:05
 */
@Configuration
@Slf4j
public class DruidConfig {


    @Value("${druid.user-mapping}")
    private String urlMapping;
    @Value("${druid.reset-enable}")
    private String resetEnable;
    @Value("${druid.allow}")
    private String allow;
    @Value("${druid.login-username}")
    private String loginUsername;
    @Value("${druid.login-password}")
    private String loginPassword;
    @Value("${druid.deny}")
    private String deny;
    @Value("${druid.exclusions}")
    private String exclusions;


    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings(urlMapping);
        Map<String, String> initParameters = Maps.newHashMap();
        initParameters.put("resetEnable", resetEnable);         //禁用HTML页面上的“Rest All”功能
        initParameters.put("allow", allow);                     //ip白名单（没有配置或者为空，则允许所有访问）
        initParameters.put("loginUsername", loginUsername);     //监控页面登录用户名
        initParameters.put("loginPassword", loginPassword);     //监控页面登录用户密码
        initParameters.put("deny", deny);                       //ip黑名单, 如果某个ip同时存在，deny优先于allow
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = Maps.newHashMap();
        initParams.put("exclusions", exclusions);

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }



}
