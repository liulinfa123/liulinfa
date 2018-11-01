package com.app.admin.controller;


import com.app.exception.ResponseMessage;
import com.app.utils.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/backstage")
public class BackstageController {

    @RequestMapping("text")
    public ResponseMessage text(String a){
        System.out.println(a);
        return ResultUtil.success(a);
    }


}
