package com.buy.dao.user;

import com.buy.entity.EasybuyUser;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
    EasybuyUser loginByName(String name) throws SQLException;
    /**
     * 登陆查询是否成功
     * @param name
     * @param password
     * @return
     */
    int queryAllUser(String name,String password);

    /**
     *
     * @return
     */
    int addUser(EasybuyUser user);
}
