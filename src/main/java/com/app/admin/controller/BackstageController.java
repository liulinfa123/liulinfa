package com.app.admin.controller;


import com.app.admin.dto.GetRegisterDTO;
import com.app.exception.ResponseMessage;
import com.app.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Api(value = "测试接口1")
@RestController
@RequestMapping("/backstage")
public class BackstageController {

    @PostMapping("text")
    @ApiOperation(value = "测试接口",notes = "接口描述")
    public ResponseMessage text(@RequestBody GetRegisterDTO getTestDTO){
        log.info(getTestDTO.getPassword());
        System.out.println(getTestDTO);
        return ResultUtil.success("you name is " + getTestDTO.getUsername());
    }


}
