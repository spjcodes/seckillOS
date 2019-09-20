package com.spj.miaosha.dao;

import com.spj.miaosha.dataobject.product;

public interface productMapper {
    int deleteByPrimaryKey(String id);

    int insert(product record);

    int insertSelective(product record);

    product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(product record);

    int updateByPrimaryKey(product record);
}