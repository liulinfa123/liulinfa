package com.app.admin.service.impl;

import com.app.admin.dao.UserBackstageDao;
import com.app.admin.dto.ChangePWDTO;
import com.app.admin.model.UserBackstage;
import com.app.admin.service.AdminLoginService;
import com.app.exception.MyException;
import com.app.utils.ResultEnum;
import com.app.utils.TokenUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author: ben
 * @Date: 2018/11/8 17:01
 */
@Service
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
    public UserBackstage verificationUser(String username, String phone, String password) throws MyException {
        UserBackstage userBackstage = StringUtils.isEmpty(username) ? userBackstageDao.findUserBackstageByphone(phone,password):userBackstageDao.findUserBackstageByusername(username, password);
        if (userBackstage == null) {
            throw new MyException(ResultEnum.LOGIN_ERROR);
        }
        // 生成token
        String token = StringUtils.isEmpty(userBackstage.getToken()) ? TokenUtil.getInstance().makeToken():userBackstage.getToken();
        // 将token存进map
        TokenUtil.map.put(userBackstage.getId(),token);
        // 也存进数据库
        userBackstageDao.UpdateTokenById(token,userBackstage.getId());
        return userBackstage;
    }

    /**
     * 注册后台帐号
     * @param username
     * @param phone
     * @param password
     * @return
     * @throws MyException
     */
    @Override
    public String addAdminUser(String username, String phone, String password,String name,String image) throws MyException {

        UserBackstage userBackstage = StringUtils.isEmpty(username) ? userBackstageDao.findUserBackstageByphone(phone,password):userBackstageDao.findUserBackstageByusername(username, password);

        if (userBackstage != null) {
            throw new MyException(400,"该用户名或手机号码已存在");
        }
        String id = UUID.randomUUID().toString();
        userBackstage = new UserBackstage();
        userBackstage.setName(name);
        userBackstage.setImage(image);
        userBackstage.setUsername(username);
        userBackstage.setPassword(password);
        userBackstage.setPhone(phone);
        userBackstage.setId(id);
        userBackstageDao.insertUserBackstage(userBackstage);
        return id;
    }

    /**
     * 注册后台帐号 这个是注释 写不写都可以
     * @param username
     * @param newPassword
     * @param password
     * @Param resultpassword
     * @return
     * @throws MyException
     */
    @Override
    public void updateUserPassword(String username, String password, String newPassword,String resultpassword) throws MyException {
        // 这里需要什么参数 username password newpassword resultpassword 必须先写在interface这里

        // 然后你需要先判断哪些参数不能为null 用StringUtils.isEmpty判断
        // 如果有一些必要参数为 null 就抛出异常 throw new MyException (400,然后你需要提示的东西)

        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)||StringUtils.isEmpty(newPassword)||StringUtils.isEmpty(resultpassword)){
                throw new MyException(400,"参数不能为空");
          }

        // 然后需要根据username去查他原来的密码 跟前端传进来的password一不一样 如果不一样 同样抛出异常 如上
        // 根据username 去查就需要写sql了
        List<String> oldPasswords = userBackstageDao.findUserBackstageByUserName(username);
        String oldPassword = "";
        if (!CollectionUtils.isEmpty(oldPasswords)) {
            oldPassword = oldPasswords.get(0);
        }
        if (!oldPassword.equals(password)){
            throw new MyException(400,"密码不一致");
        }
        // 然后确认完之后
        // 修改数据库的密码字段
        userBackstageDao.updatePasswordByUserName(newPassword,username);
        // 修改成功就返回 如果是void 就不用返回

    }



}
