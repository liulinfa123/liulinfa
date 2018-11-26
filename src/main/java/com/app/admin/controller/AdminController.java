package com.app.admin.controller;


import cn.hutool.core.date.DateTime;
import com.app.admin.dao.UserBackstageDao;
import com.app.admin.model.UserBackstage;
import com.app.admin.service.AdminLoginService;
import com.app.exception.MyException;
import com.app.exception.ResponseMessage;
import com.app.utils.ResultEnum;
import com.app.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ben
 * @Date: 2018/11/8 17:00
 */
@Slf4j
@RestController
@RequestMapping("/admin")
@Api(value = "后台管理")
public class AdminController {

    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("backstageLogin")
    @ApiOperation(value = "登录",notes = "后台登录")
    public ResponseMessage backstageLogin(@RequestParam(value = "password") String password,
                                           @RequestParam(value = "username") String username,
                                           @RequestParam(value = "phone",required = false) String phone){
        try{
            adminLoginService.verificationUser(username,phone,password);
        }catch (MyException e){
            log.error(e.getMessage(),e);
            return ResultUtil.error(ResultEnum.LOGIN_ERROR);
        }
        return ResultUtil.success("");
    }

    @PostMapping("backstageRegister")
    @ApiOperation(value = "后台注册",notes = "后台新增帐号")
    public ResponseMessage backstageRegister(@RequestParam(value = "password") String password,
                                          @RequestParam(value = "username") String username,
                                          @RequestParam(value = "phone",required = false) String phone){
        try{
            adminLoginService.addAdminUser(username,phone,password);
        }catch (MyException e){
            log.error(e.getMessage(),e);
            return ResultUtil.error(400,e.getMessage()== null ?ResultEnum.SYSTEM_ERROR.getMsg():e.getMessage());
        }
        return ResultUtil.success("");
    }



}
