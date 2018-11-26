package com.app.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录/注册所需参数")
public class GetLoginDTO {

    @ApiModelProperty("姓名")
    private String username;


    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机")
    private String phone;

}
