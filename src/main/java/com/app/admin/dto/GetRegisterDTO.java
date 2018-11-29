package com.app.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("注册所需参数")
public class GetRegisterDTO {

    @ApiModelProperty("用户名")
    private String username;


    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("用户昵称")
    private String name;

    @ApiModelProperty("头像")
    private String image;

}
