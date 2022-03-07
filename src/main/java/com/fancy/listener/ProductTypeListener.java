package com.fancy.listener;

import com.fancy.pojo.ProductType;
import com.fancy.services.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ProductTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //手工从Spring容器中取出 ProductTypeServiceImpl

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductTypeService productTypeService = (ProductTypeService) context.getBean("productTypeServiceImpl");
        List<ProductType> typeList = productTypeService.getAll();
        //放入全局作用域中, 供新增商品页面、修改页面，前台的查询功能提供全部商品的类别集合
        sce.getServletContext().setAttribute("typeList", typeList);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
