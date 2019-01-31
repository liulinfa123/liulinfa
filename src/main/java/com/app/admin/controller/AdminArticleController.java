package com.app.admin.controller;

import com.app.admin.dto.AddArticleDTO;
import com.app.admin.dto.AddTypesDTO;
import com.app.admin.service.ArticleService;
import com.app.exception.MyException;
import com.app.exception.ResponseMessage;
import com.app.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ben
 * @Date: 2019/1/2 14:31
 */
@Slf4j
@RestController
@RequestMapping("/article")
@Api(value = "后台文章接口")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("addTypes")
    @ApiOperation(value = "类型",notes = "后台添加类型")
    public ResponseMessage addTypes(@RequestBody AddTypesDTO addTypesDTO){

        articleService.addTypes(addTypesDTO.getId(),addTypesDTO.getName(),addTypesDTO.getUserBackstageId());
        return ResultUtil.success();
    }


    @PostMapping("addArticle")
    @ApiOperation(value = "文章",notes = "后台发布文章")
    public ResponseMessage addArticle(@RequestBody AddArticleDTO addArticleDTO){
        try{
            articleService.addArticle(addArticleDTO.getUserBackstageId(),addArticleDTO.getTitle(),addArticleDTO.getContent(),addArticleDTO.getTypesId(),addArticleDTO.getTopping());
        }catch (MyException e){
            log.error(e.getErrorMsg(),e);
            return ResultUtil.error(400,e.getMessage() == null ? "服务器繁忙":e.getMessage());
        }
        return ResultUtil.success();
    }




}
