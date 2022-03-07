package com.fancy.dao;

import com.fancy.pojo.ProductType;

import java.util.List;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    ProductType selectByPrimaryKey(Integer typeId);

    List<ProductType> selectAll();

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}