package com.spj.miaosha.dao;

import com.spj.miaosha.dataobject.UserDO;

public interface UserDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    String selectIdByTelephone(String telephone);

    UserDO selectByName(String username);

    UserDO selectDoByTelephone(String telephone);
}