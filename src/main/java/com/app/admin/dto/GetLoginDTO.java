package com.app.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ben
 * @Date: 2018/11/29 11:31
 */
@Data
@ApiModel("登录所需参数")
public class GetLoginDTO {

    @ApiModelProperty("用户名")
    private String username;


    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机")
    private String phone;

}
