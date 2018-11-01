package com.app.admin.controller;


import com.app.admin.model.GetTestDTO;
import com.app.exception.ResponseMessage;
import com.app.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@Api(value = "测试接口1")
@RestController
@RequestMapping("/backstage")
public class BackstageController {

    @PostMapping("text")
    @ApiOperation(value = "测试接口",notes = "接口描述")
    public ResponseMessage text(@RequestBody GetTestDTO getTestDTO){
        System.out.println(getTestDTO);
        return ResultUtil.success("you name is " + getTestDTO.getName());
    }


}
