package com.fancy.dao;

import com.fancy.pojo.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKeyWithBLOBs(Users record);

    int updateByPrimaryKey(Users record);
}