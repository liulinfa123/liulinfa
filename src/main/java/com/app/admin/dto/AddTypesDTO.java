package com.app.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ben
 * @Date: 2019/1/3 11:38
 */
@Data
@ApiModel("添加类型所需参数")
public class AddTypesDTO {

    @ApiModelProperty(value = "类型名字",required = true)
    private String name;

    @ApiModelProperty(value = "类型id")
    private String id;

    @ApiModelProperty(value = "操作人id",required = true)
    private String userBackstageId;


}
