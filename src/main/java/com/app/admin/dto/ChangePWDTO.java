package com.app.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改密码所需参数")
public class ChangePWDTO {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("原始密码")
    private String passWord;

    @ApiModelProperty("新密码")
    private String newPassWord;

    @ApiModelProperty("确认新密码")
    private String resultPassWord;



}
