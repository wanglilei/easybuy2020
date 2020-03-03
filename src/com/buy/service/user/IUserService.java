package com.buy.service.user;

import com.buy.entity.EasybuyUser;

import java.sql.SQLException;

public interface IUserService {

    EasybuyUser loginByName(String name) throws SQLException;
    int queryAllUser(String name,String password);

    boolean save(EasybuyUser user);
}
