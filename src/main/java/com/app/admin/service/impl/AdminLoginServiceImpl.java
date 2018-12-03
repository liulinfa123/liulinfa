package com.app.admin.service.impl;

import com.app.admin.dao.UserBackstageDao;
import com.app.admin.model.UserBackstage;
import com.app.admin.service.AdminLoginService;
import com.app.exception.MyException;
import com.app.utils.ResultEnum;
import com.app.utils.TokenUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        userBackstage.setId(UUID.randomUUID().toString());
        userBackstageDao.insertUserBackstage(userBackstage);
        return id;
    }
}
