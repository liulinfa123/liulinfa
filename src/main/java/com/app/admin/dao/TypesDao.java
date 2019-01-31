package com.app.admin.dao;

import com.app.admin.model.Types;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ben
 * @Date: 2019/1/2 14:33
 */
public interface TypesDao {

    int insertTypes(Types types);

    Types findOne(String id);

    void updateOne(Types types);


}
