package com.lsk.services.impl;

import com.lsk.domain.AccountBook;
import com.lsk.mappers.AccountBookMapper;
import com.lsk.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountBookMapper accountBookMapper;

    @Override
    public int addAccount(AccountBook accountBook) {

        try {
            accountBookMapper.addAccount(accountBook);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<AccountBook> findAccList(AccountBook accountBook) {
        return accountBookMapper.findAccountByDate(accountBook);
    }

    @Override
    public double findDayCost(AccountBook accountBook) {
        return accountBookMapper.findDayCost(accountBook);
    }

    @Override
    public int deleteAccount(int id) {
        try {
            accountBookMapper.deleteAccount(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public AccountBook selectAccountById(int id) {
        return accountBookMapper.selectAccountById(id);
    }

    @Override
    public double findMonCost(AccountBook accountBook) {
        return accountBookMapper.findMonCost(accountBook);
    }


}
