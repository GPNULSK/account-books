package com.lsk.controller;

import com.lsk.common.ComResult;
import com.lsk.domain.AccountBook;
import com.lsk.domain.Userinfo;
import com.lsk.services.AccountService;
import com.lsk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    private int code=0;

    private String message="";

    @RequestMapping("/addAcc")
    public ComResult addAcc(String tel,int bid,String today,double perCost,String description) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today1 = dateFormat.parse(today);

        //查找月总消费
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM");
        Date month = dateFormat1.parse(today);
        AccountBook accountBook1 = new AccountBook();
        accountBook1.setBookId(bid);
        accountBook1.setToday(month);
        double monCost = accountService.findMonCost(accountBook1) + perCost;

        //查找出本月所有钱
        Userinfo userInfo = userService.findUserInfo(tel);

        //设置值和保存消费记录
        AccountBook accountBook = new AccountBook();
        accountBook.setBookId(bid);
        accountBook.setToday(today1);
        accountBook.setDescription(description);
        accountBook.setMonCost(monCost);
        accountBook.setMonRemainder(userInfo.getTotalMoney() - monCost);
        int i = accountService.addAccount(accountBook);

        //更新用户表中的总消费和余额
        Userinfo info = new Userinfo();
        info.setTel(tel);
        info.setTotalCost(monCost);
        info.setMonDeposit(userInfo.getTotalMoney() - monCost);
        info.setYearDeposit(userInfo.getYearDeposit() + monCost);
        int i1 = userService.updateUserInfo(info);

        if( i ==1 && i1 == 1){
            code = 200;
            message = "添加成功";
        }else {
            code = 500;
            message = "添加失败";
        }

        return new ComResult(code,message,null);
    }
}
