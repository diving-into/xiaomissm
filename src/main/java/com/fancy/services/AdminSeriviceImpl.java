package com.fancy.services;

import com.fancy.dao.AdminMapper;
import com.fancy.pojo.Admin;
import com.fancy.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSeriviceImpl implements AdminService{
    //在业务层中, 一定有持久层对象
    @Autowired
    AdminMapper adminMapper;


    @Override
    public Admin login(String name, String pwd) {

        //根据传入的用户或到DB中查询相应用户对象
        Admin admin = adminMapper.selectByName(name);

        if(admin != null) {
           //如果查询到用户对象, 在进行密码比对, 注意密码是密文
            String mPwd = MD5Util.getMD5(pwd);
            //在进行密码对比时,要将传入的pwd进行md5加密,再与数据库中查到的对象的密码进行对比
            if (mPwd.equals(admin.getaPass())) {
                return admin;
            }
        }
        return  null;
    }
}
