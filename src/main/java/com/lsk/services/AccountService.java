package com.lsk.services;

import com.lsk.domain.AccountBook;

import java.util.List;

public interface AccountService{

    /**
     * 添加单条记账记录，bid跟uid关联
     * @param accountBook
     * @return
     */
    int addAccount(AccountBook accountBook);

    /**
     * 查找出某天所有的消费记录
     * @param accountBook
     * @return
     */
    List<AccountBook> findAccList(AccountBook accountBook);

    //查找一天的总消费，就是表中一天总消费数的最大值
    double findDayCost(AccountBook accountBook);

    //删除单条账本记录
    int deleteAccount(int id);

    //查看某个的详情
    AccountBook selectAccountById(int id);

    double findMonCost(AccountBook accountBook);


}
