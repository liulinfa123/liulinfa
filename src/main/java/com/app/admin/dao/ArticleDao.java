package com.app.admin.dao;


import com.app.admin.model.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao {

    int insertArticle(Article article);

}
