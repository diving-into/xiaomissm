package com.fancy.services;

import com.fancy.dao.ProductInfoMapper;
import com.fancy.pojo.ProductInfo;
import com.fancy.pojo.ProductInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    // 业务层中一定有持久层对象
    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectAll();
    }

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        //使用分页插件 PageHelper 工具类完成分页设置
        PageHelper.startPage(pageNum, pageSize);

        List<ProductInfo> list = productInfoMapper.selectAll();

        //将查询到的集合封装进 PageInfo 对象中
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public int save(ProductInfo info) {
        return productInfoMapper.insert(info);
    }
}
