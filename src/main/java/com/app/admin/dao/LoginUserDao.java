package com.app.admin.dao;

import com.app.admin.model.LoginUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @Author: ben
* @Date: 2018/11/8 16:50
*/
public interface LoginUserDao {

    int insertLoginUser(LoginUser loginUser);

}
