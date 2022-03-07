package com.fancy.dao;

import com.fancy.pojo.Orderdetail;

public interface OrderdetailMapper {
    int deleteByPrimaryKey(Integer odid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer odid);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}