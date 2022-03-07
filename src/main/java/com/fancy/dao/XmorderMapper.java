package com.fancy.dao;

import com.fancy.pojo.Xmorder;

public interface XmorderMapper {
    int deleteByPrimaryKey(String oid);

    int insert(Xmorder record);

    int insertSelective(Xmorder record);

    Xmorder selectByPrimaryKey(String oid);

    int updateByPrimaryKeySelective(Xmorder record);

    int updateByPrimaryKey(Xmorder record);
}