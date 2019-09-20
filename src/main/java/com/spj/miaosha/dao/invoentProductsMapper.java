package com.spj.miaosha.dao;

import com.spj.miaosha.dataobject.invoentProducts;

public interface invoentProductsMapper {
    int deleteByPrimaryKey(String id);

    int insert(invoentProducts record);

    int insertSelective(invoentProducts record);

    invoentProducts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(invoentProducts record);

    int updateByPrimaryKey(invoentProducts record);
}