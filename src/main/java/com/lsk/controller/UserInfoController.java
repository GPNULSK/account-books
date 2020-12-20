package com.lsk.controller;

import com.lsk.common.ComResult;
import com.lsk.domain.Userinfo;
import com.lsk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    private int  code;
    private String message;

    /**
     * 新用户添加信息
     * @param tel
     * @return
     */
    @RequestMapping("/createUser")
    public ComResult createUser(String tel){

        int result = userService.createUserInfo(tel);
        if (result == 1){
            code  = 200;
            message = "添加成功";
        }else {
            code = 500;
            message = "添加失败";
        }
        return new ComResult(code,message,null);
    }

    /**
     * 更改用户的账本主体信息，如起始日期和总金钱
     * @param uid
     * @param tel
     * @param startDate
     * @param totalMoney
     * @return
     * @throws ParseException
     */
    @RequestMapping("/addUserInfo")
    public ComResult addUserInfo(int uid,String tel,String startDate,double totalMoney) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(startDate);
        Userinfo userinfo = new Userinfo();
        userinfo.setTel(tel);
        userinfo.setStartDate(date);
        userinfo.setTotalMoney(totalMoney);

        int i = userService.updateUserInfo(userinfo);

        if (i == 1){
            code = 200;
            message = "更新成功";
        }else {
            code = 500;
            message = "更新失败";
        }

        return new ComResult(code,message,null);
    }

    @RequestMapping("/findUserInfo")
    public ComResult findUserInfo(String tel){
        Userinfo userInfo = userService.findUserInfo(tel);
        if(userInfo == null){
            code = 200;
            message = "没有找到用户信息";
        }else if( userInfo != null){
            code = 200;
            message = "查找用户信息成功";
        }else {
            code = 500;
            message = "出现异常";
        }

        return new ComResult(code,message,userInfo);
    }
}
