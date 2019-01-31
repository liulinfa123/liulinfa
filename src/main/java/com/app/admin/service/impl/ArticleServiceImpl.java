package com.app.admin.service.impl;

import com.app.admin.dao.ArticleDao;
import com.app.admin.dao.TypesDao;
import com.app.admin.model.Article;
import com.app.admin.model.Types;
import com.app.admin.service.ArticleService;
import com.app.exception.MyException;
import com.app.utils.ResultEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ben
 * @Date: 2019/1/2 14:55
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private TypesDao typesDao;

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void addTypes(String id, String name,String userBackstageId) {
        // 添加
        if (StringUtils.isEmpty(id)) {
            Types types = Types.builder().name(name).userBackstageId(userBackstageId).build();
            typesDao.insertTypes(types);
            return;
        }
        // 编辑
        Types types = Types.builder().name(name).userBackstageId(userBackstageId).build();
        types.setId(id);
        typesDao.updateOne(types);
    }


    @Override
    public void addArticle(String userBackstageId, String title, String content, String typesId, boolean topping) {

        Article article = Article.builder().content(content).title(title).topping(topping).typesId(typesId).userBackstageId(userBackstageId)
                .build();
        int i = articleDao.insertArticle(article);
        if (i == 0) {
            throw new MyException(ResultEnum.ADDERROR);
        }
    }
}
