package com.lsk.services.impl;

import com.lsk.domain.Userinfo;
import com.lsk.mappers.UserinfoMapper;
import com.lsk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public int createUserInfo(String tel) {
        try {
            userinfoMapper.createUser(tel);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Userinfo findUserInfo(String tel) {
        return userinfoMapper.findUserByTel(tel);
    }

    @Override
    public int updateUserInfo(Userinfo userinfo) {
        try {
            userinfoMapper.updateUserInfo(userinfo);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
