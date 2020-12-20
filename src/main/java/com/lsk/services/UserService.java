package com.lsk.services;

import com.lsk.domain.Userinfo;

public interface UserService {

    //没有账号时创建账号
    int createUserInfo(String tel);

    //查找用户的所有信息
    Userinfo findUserInfo(String tel);

    //根据电话号码更改用户的信息，如开始日期，总存款
    int updateUserInfo(Userinfo userinfo);
}
