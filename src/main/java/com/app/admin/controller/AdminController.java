package com.app.admin.controller;


import cn.hutool.core.bean.BeanUtil;
import com.app.admin.dto.ChangePWDTO;
import com.app.admin.dto.GetLoginDTO;
import com.app.admin.dto.GetRegisterDTO;
import com.app.admin.dto.ReturnLoginDTO;
import com.app.admin.model.UserBackstage;
import com.app.admin.service.AdminLoginService;
import com.app.exception.MyException;
import com.app.exception.ResponseMessage;
import com.app.utils.ResultEnum;
import com.app.utils.ResultUtil;
import com.app.utils.SecurityUtil;
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
    public ResponseMessage backstageLogin(@RequestBody GetLoginDTO getLoginDTO){
        try{
            String username = getLoginDTO.getUsername();
            String password = getLoginDTO.getPassword();
            String phone = getLoginDTO.getPhone();
            UserBackstage userBackstage = adminLoginService.verificationUser(username, phone, password);
            ReturnLoginDTO returnLoginDTO = new ReturnLoginDTO();
            BeanUtil.copyProperties(userBackstage,returnLoginDTO);
            return ResultUtil.success(returnLoginDTO);
        }catch (MyException e){
            log.error(e.getErrorMsg(),e);
            return ResultUtil.error(ResultEnum.LOGIN_ERROR);
        }
    }

    @PostMapping("backstageRegister")
    @ApiOperation(value = "后台注册",notes = "后台新增帐号")
    public ResponseMessage backstageRegister(@RequestBody GetRegisterDTO getRegisterDTO){
        try{
            String username = getRegisterDTO.getUsername();
            String password = getRegisterDTO.getPassword();
            String phone = getRegisterDTO.getPhone();
            String name = getRegisterDTO.getName();
            String image = getRegisterDTO.getImage();
            adminLoginService.addAdminUser(username,phone,password,name,image);
        }catch (MyException e){
            log.error(e.getErrorMsg(),e);
            return ResultUtil.error(400,e.getErrorMsg()== null ?ResultEnum.SYSTEM_ERROR.getMsg():e.getErrorMsg());
        }
        return ResultUtil.success("");
    }

    @PostMapping("getText")
    @ApiOperation(value = "后台测试",notes = "测试专用")
    public ResponseMessage getText(){
        System.out.println("getText");
        return ResultUtil.success();
    }

    @PostMapping("changePW")
    @ApiOperation(value = "修改密码测试",notes = "修改密码")
    public  ResponseMessage changePW(@RequestBody ChangePWDTO changePWDTO){
        try{
            String username = changePWDTO.getUserName();
            String password = changePWDTO.getPassWord();
            String newpassword = changePWDTO.getNewPassWord();
            String resultpassword = changePWDTO.getResultPassWord();
            adminLoginService.updateUserPassword(username,password,newpassword,resultpassword);
            System.out.println("修改成功");
        }catch (MyException e){
            // 记录日志很重要
            log.error(e.getErrorMsg(),e);
            return ResultUtil.error(400,e.getErrorMsg()== null ?ResultEnum.SYSTEM_ERROR.getMsg():e.getErrorMsg());
        }
        return ResultUtil.success("修改成功");
    }




}
