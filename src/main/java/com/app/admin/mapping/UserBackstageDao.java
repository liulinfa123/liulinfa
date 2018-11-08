package com.app.admin.mapping;

import com.app.admin.model.UserBackstage;

/**
 * @Author: ben
 * @Date: 2018/11/8 16:50
 */
public interface UserBackstageDao {

    int insertUserBackstage(UserBackstage userBackstage);

    UserBackstage findUserBackstageByusername(String username,String password);

    UserBackstage findUserBackstageByphone(String phone,String password);

}
