package com.app.admin.service.impl;

import com.app.admin.dao.UserBackstageDao;
import com.app.admin.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ben
 * @Date: 2018/11/8 17:01
 */
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private UserBackstageDao userBackstageDao;

    /**
     *  验证登录过程
     * @param username
     * @param phone
     * @param password
     */
    @Override
    public void verificationUser(String username, String phone, String password) {

    }
}
