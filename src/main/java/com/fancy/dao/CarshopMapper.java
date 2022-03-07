package com.fancy.dao;

import com.fancy.pojo.Carshop;

public interface CarshopMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Carshop record);

    int insertSelective(Carshop record);

    Carshop selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Carshop record);

    int updateByPrimaryKey(Carshop record);
}