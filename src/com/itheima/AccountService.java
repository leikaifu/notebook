package com.itheima;

/**
 * 转账业务层接口
 * @author
 */
public interface AccountService {

    public void transfer(String from,String to, double money);
}
