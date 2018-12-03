package com.app.admin.service;

import com.app.admin.model.UserBackstage;
import com.app.exception.MyException;

/**
 * @Author: ben
 * @Date: 2018/11/8 17:00
 */
public interface AdminLoginService {

    UserBackstage verificationUser(String username,String phone,String password) throws MyException;

    String addAdminUser(String username, String phone, String password,String name,String image) throws MyException;

    // 这里是interface 所以要实现这个
    void updateUserPassword(String username, String password, String newPassword,String resultpassword) throws MyException;
}
