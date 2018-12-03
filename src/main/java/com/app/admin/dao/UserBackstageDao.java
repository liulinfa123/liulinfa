package com.app.admin.dao;

import com.app.admin.model.UserBackstage;
import org.apache.ibatis.annotations.Param;

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

    void UpdateTokenById(@Param(value = "token") String token,@Param(value = "id") String id);
    // 命名一定要规范 查询就是find  By 根据什么来查 @Param 这个参数一定要跟mapper的一样 findUserBackstageByUserName这个就是mapper的id
    List<String> findUserBackstageByUserName(@Param(value = "username") String username);
    // 更新 根据id 来修改数据 or 根据username来更新数据
    String updatePasswordByUserName(@Param(value = "password") String password,@Param(value = "username") String username);



}
