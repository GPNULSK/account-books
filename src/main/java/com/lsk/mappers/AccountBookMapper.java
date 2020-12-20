package com.lsk.mappers;

import com.lsk.domain.AccountBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountBookMapper {
    //添加账本
    void addAccount(AccountBook accountBook);

    //查找一天的总消费，就是表中一天总消费数的最大值
    double findDayCost(AccountBook accountBook);

    //删除单条账本记录
    void deleteAccount(int id);

    //查找出某天所有消费记录
    List<AccountBook> findAccountByDate(AccountBook accountBook);

    //查看某个的详情
    AccountBook findAccountById(int id);

    double findMonCost(AccountBook accountBook);
}