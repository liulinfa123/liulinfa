package com.app.admin.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ben
 * @Date: 2019/1/2 14:31
 */
@Data
@ApiModel("发布文章所需参数")
public class AddArticleDTO {

    @ApiModelProperty(value = "作者id",required = true)
    private String userBackstageId;

    @ApiModelProperty(value = "标题",required = true)
    private String title;

    @ApiModelProperty(value = "内容",required = true)
    private String content;

    @ApiModelProperty(value = "是否置顶",required = true)
    private Boolean topping;

    @ApiModelProperty(value = "类型id",required = true)
    private String typesId;

}
