package com.fancy.dao;

import com.fancy.pojo.ProductInfo;
import com.fancy.pojo.ProductType;

import java.util.List;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer pId);

    List<ProductInfo> selectAll();

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}