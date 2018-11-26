package com.app.admin.model;

import com.app.admin.service.impl.AdminLoginServiceImpl;
import com.app.common.model.ParentModel;
import lombok.Data;

import java.util.Map;

/**
 * @Author: ben
 * @Date: 2018/11/8 16:45
 */
@Data
public class UserBackstage extends ParentModel {



    private String username;

    private String password;

    private String phone;

}
