package com.app.admin.service.impl;

import com.app.admin.dao.LoginUserDao;
import com.app.admin.model.LoginUser;
import com.app.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginUserDao loginUserDao;

    @Override
    public int addLoginUser(LoginUser loginUser) {
        int i = loginUserDao.insertLoginUser(loginUser);
        return i;
    }
}
