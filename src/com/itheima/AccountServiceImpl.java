package com.itheima;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 转账业务层实现类
 * from：转出账号
 * to:转入账号
 * money:转账金额
 */
public class AccountServiceImpl implements AccountService{
    //    注入接口Dao
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    /**
     * from 是转出账号
     * to   是转入账号
     * money 转账金额
     */
    public void transfer(String from, String to, double money) {
        accountDao.Inmoney(to, money);
        accountDao.Outmoney(from, money);
    }
}
