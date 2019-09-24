package com.spj.miaosha.dao;

import com.spj.miaosha.dataobject.ProductDO;

public interface ProductDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductDO record);

    int insertSelective(ProductDO record);

    ProductDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductDO record);

    int updateByPrimaryKey(ProductDO record);

    String selectIdByName(String productName);
}