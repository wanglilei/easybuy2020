package com.buy.service.user;

import com.buy.dao.user.IUser;
import com.buy.dao.user.EasybuyUserImpl;
import com.buy.entity.EasybuyUser;
import com.buy.service.user.IUserService;

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
    public boolean save(EasybuyUser user) {
        return users.save(user)>0?true:false;
    }
}
