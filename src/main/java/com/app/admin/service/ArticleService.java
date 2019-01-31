package com.app.admin.service;

import org.springframework.stereotype.Service;

/**
 * @Author: ben
 * @Date: 2019/1/2 14:54
 */
public interface ArticleService {


    void addTypes(String id,String name,String userBackstageId);

    void addArticle(String userBackstageId,String title,String content,String typesId,boolean topping);

}
