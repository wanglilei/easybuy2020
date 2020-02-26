package com.buy.service.product;

import com.buy.dao.user.IUser;
import com.buy.dao.user.EasybuyUserImpl;
import com.buy.entity.EasybuyUser;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    IUser users = new EasybuyUserImpl();

    @Override
    public EasybuyUser loginByName(String name) throws SQLException {
        return users.loginByName(name);
    }

    @Override
    public int queryAllUser(String name, String password) {
        return users.queryAllUser(name,password);
    }

    @Override
    public int addUser(EasybuyUser user) {
        return users.addUser(user);
    }
}
