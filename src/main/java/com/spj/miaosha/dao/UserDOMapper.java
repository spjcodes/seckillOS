package com.spj.miaosha.dao;

import com.spj.miaosha.dataobject.UserDO;
import org.apache.ibatis.annotations.Select;

public interface UserDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    @Select("select * from user_info where id = #{id}")
    UserDO selectUserDo(String id);
}