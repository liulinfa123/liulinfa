package com.app.common.model;

import lombok.Data;

/**
 * @Author: ben
 * @Date: 2018/11/8 16:48
 *  todo 所有的数据库实体类都必须继承该class
 */
@Data
public class ParentModel {

    private String id;

    private long createDate = System.currentTimeMillis();

    private long updateDate;

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }
}
