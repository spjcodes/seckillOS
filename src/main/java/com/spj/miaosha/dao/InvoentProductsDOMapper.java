package com.spj.miaosha.dao;

import com.spj.miaosha.dataobject.InvoentProductsDO;

public interface InvoentProductsDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(InvoentProductsDO record);

    int insertSelective(InvoentProductsDO record);

    InvoentProductsDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InvoentProductsDO record);

    int updateByPrimaryKey(InvoentProductsDO record);
}