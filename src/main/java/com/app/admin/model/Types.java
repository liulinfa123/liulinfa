package com.app.admin.model;

import com.app.common.model.ParentModel;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: ben
 * @Date: 2019/1/2 14:47
 */
@Data
@Builder
public class Types extends ParentModel {

    private boolean strikeOut;

    private String name;

    private String userBackstageId;
}
