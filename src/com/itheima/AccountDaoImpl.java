package com.itheima;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

//JdbcDaoSupport
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void Outmoney(String from, double money) {
        this.getJdbcTemplate().update("UPDATE account set money=money - ? WHERE name=? ",money,from);
    }

    @Override
    public void Inmoney(String to, double money) {
        this.getJdbcTemplate().update("UPDATE account set money=money+? WHERE name=?",money,to);

    }
}
