package com.app.admin.model;

import com.app.common.model.ParentModel;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: ben
 * @Date: 2019/1/2 14:33
 */
@Data
@Builder
public class Article extends ParentModel {

    private boolean strikeOut;

    private String userBackstageId;

    private String title;

    private String content;

    private String typesId;

    private boolean topping;

}
