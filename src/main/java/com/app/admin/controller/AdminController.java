package com.app.admin.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.app.admin.model.UserBackstage;
import com.app.exception.ResponseMessage;
import com.app.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/admin")
@Api(value = "后台管理")
public class AdminController {

    @PostMapping("backstageLogin")
    @ApiOperation(value = "登录",notes = "后台登录")
    private ResponseMessage backstageLogin(@RequestParam(value = "password") String password,
                                           @RequestParam(value = "username") String username){

        UserBackstage userBackstage = new UserBackstage();
        userBackstage.setCreate_date(DateTime.now().getTime());
        userBackstage.setUpdate_date(DateTime.now().getTime());
        userBackstage.setUsername(username);
        userBackstage.setPassword(password);

        return ResultUtil.success("");
    }


}
