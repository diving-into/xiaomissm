package com.fancy.controllers;

import com.fancy.pojo.ProductInfo;
import com.fancy.services.ProductInfoService;
import com.fancy.utils.FileNameUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/prod")
public class ProductInfoController {
    //控制层一定业务层方法
    @Autowired
    ProductInfoService productInfoService;

    //异步上传的图片的名称
    String saveFileName = "";

    @RequestMapping("/getAll.action")
    public String getAll(Model model) {
        List<ProductInfo> list = productInfoService.getAll();
        model.addAttribute("info", list);
        return "product";
    }

    @RequestMapping("/split.action")
    public String split(HttpServletRequest request) {
        PageInfo info = null;

        info = productInfoService.splitPage(1, 5);

        request.setAttribute("info", info);
        return "product";
    }

    @RequestMapping("/ajaxSplit.action")
    @ResponseBody
    public void ajaxSplit(int page, HttpSession session) {
             PageInfo info = productInfoService.splitPage(page, 5);
             session.setAttribute("info", info);
    }

    // 异步ajax文件上传处理
    //@ResponseBody注解作用就是处理ajax请求
    @ResponseBody
    @RequestMapping("/ajaxImg.action")
    public Object ajaxImg(MultipartFile pimage, HttpServletRequest request) {
        //提取生成文件名 UUID + 图片上传路径 .jpg, .png
        saveFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(pimage.getOriginalFilename());
        //得到项目中图片存储路径
        String path = request.getServletContext().getRealPath("/image_big");

        //转存
        try {
            pimage.transferTo(new File(path + File.separator + saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回客户端JSON对象,封装图片的路径,为了在页面实现立即回显
        JSONObject object = new JSONObject();
        object.put("imgurl", saveFileName);
        return object.toString();
    }

    @RequestMapping("/save.action")
    public String save(ProductInfo info, HttpServletRequest request) {
        //我们将saveFileName 定义成全局变量供多个方法进行调用
        info.setpImage(saveFileName);
        info.setpDate(new Date());
        //info对象中有表单提交上来的5个数据,有异步ajax上来的图片名称数据,有上架时间的数据
        int num = -1;
        try {
            num = productInfoService.save(info);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (num > 0) {
            request.setAttribute("msg", "增加成功!");
        } else {
            request.setAttribute("msg", "增加失败!");
        }
        //清空saveFileName变量中的内容,为了下次增加或修改的异步ajax的上传处理
        saveFileName = "";
        //增加成功后应该重新访问数据库,所以跳转到分页显示的action上
        return "forward:/prod/split.action";
    }

}
