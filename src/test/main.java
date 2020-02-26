package test;

import com.buy.entity.EasybuyUser;
import com.buy.service.product.IUserService;
import com.buy.service.product.UserServiceImpl;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.SecurityUtils;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public class main{
    //回家吧
    public static void main(String[] args) {
//        DataSourceUtil.getConn();
        IUserService service = new UserServiceImpl();
        EasybuyUser user = null;
        try {
            user = service.loginByName("admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user.getUsername());

    }
}
