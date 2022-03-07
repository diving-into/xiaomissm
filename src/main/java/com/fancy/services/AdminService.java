package com.fancy.services;

import com.fancy.pojo.Admin;

public interface AdminService {
    // 完成登录判断
    Admin login(String name, String pwd);

}
