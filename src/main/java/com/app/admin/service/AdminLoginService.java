package com.app.admin.service;

import com.app.admin.model.UserBackstage;
import com.app.exception.MyException;

/**
 * @Author: ben
 * @Date: 2018/11/8 17:00
 */
public interface AdminLoginService {

    UserBackstage verificationUser(String username,String phone,String password) throws MyException;

    String addAdminUser(String username, String phone, String password) throws MyException;

}
