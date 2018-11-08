package com.app.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("测试传入参数")
public class GetTestDTO {

    @ApiModelProperty("姓名")
    private String username;


    @ApiModelProperty("密码")
    private String password;

}
