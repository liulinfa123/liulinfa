package com.app.common.controller;

import com.app.exception.ResponseMessage;
import com.app.utils.QiniuUtil;
import com.app.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: ben
 * @Date: 2018/12/4 17:52
 */
@Slf4j
@RestController
@RequestMapping("/upload")
@Api(value = "上传文件")
public class updateFileController {

    @Autowired
    private QiniuUtil qiniuUtil;

    @PutMapping("/img")
    @ApiOperation(value = "上传",notes = "图片")
    public ResponseMessage uploadImg(@RequestParam("imageFile") MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            return ResultUtil.error(400,"请上传图片");
        }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            return ResultUtil.error(400,"图片格式错误");
        }
        String originalFilename = multipartFile.getOriginalFilename();
        log.info("上传图片:name = {},type = {} ",originalFilename,contentType);
        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
        String uploadImg = qiniuUtil.uploadImg(inputStream);
        return ResultUtil.success(uploadImg);
    }

}
