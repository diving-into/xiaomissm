package com.fancy.services;

import com.fancy.dao.ProductTypeMapper;
import com.fancy.pojo.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productTypeServiceImpl")
public class ProductTypeServiceImpl implements  ProductTypeService{
    // 在业务逻辑层 一定会有数据访问层的对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectAll();
    }
}
