package com.fancy.services;

import com.fancy.pojo.ProductInfo;
import com.fancy.pojo.ProductInfoVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ProductInfoService {
    // 显示全部商品(不分页)
    List<ProductInfo> getAll();

    PageInfo splitPage(int pageNum, int pageSize);

    public int save(ProductInfo info);

}
