package com.app.admin.dao;

import com.app.admin.model.UserBackstage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: ben
 * @Date: 2018/11/8 16:50
 */
public interface UserBackstageDao {

    void insertUserBackstage(UserBackstage userBackstage);

    UserBackstage findUserBackstageByusername(@Param(value = "username") String username, @Param(value = "password") String password);

    UserBackstage findUserBackstageByphone(@Param(value = "phone") String phone,@Param(value = "password") String password);

    UserBackstage findUserBackstageById(@Param(value = "id") String id,@Param(value = "token") String token);

    void updateTokenById(UserBackstage userBackstage);

    @Select("select password from user_backstage where username = #{username}")
    List<String> findUserBackstageByUserName(@Param(value = "username") String username);

    void updatePasswordByUserName(UserBackstage userBackstage);



}
