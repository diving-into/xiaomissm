package com.fancy.dao;

import com.fancy.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);

    Admin selectByName(String aName);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}