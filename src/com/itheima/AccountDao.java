package com.itheima;

/**
 * 转账Dao接口
 */
public interface AccountDao {
    public void Outmoney(String from,double money);
    public void Inmoney(String to,double money);
}
