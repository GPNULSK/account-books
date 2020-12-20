package com.lsk.mappers;

import com.lsk.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserinfoMapper {

    //根据电话号码获取账户信息
    Userinfo findUserByTel(String tel);

    //根据电话号码创建账号，电话号码是唯一标识
    void createUser(String tel);

    //根据电话号码更改用户的信息，如开始日期，总存款
    void updateUserInfo(Userinfo userinfo);
}