package test;

import com.buy.entity.EasybuyNews;
import com.buy.entity.EasybuyUser;
import com.buy.service.news.INewsService;
import com.buy.service.news.NewsServiceImpl;
import com.buy.service.product.IUserService;
import com.buy.service.product.UserServiceImpl;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.SecurityUtils;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

public class main{
    //回家吧
    public static void main(String[] args) {
//        DataSourceUtil.getConn();
//        IUserService service = new UserServiceImpl();
//        EasybuyUser user = new EasybuyUser();
//        user.setLoginname("name");
//        user.setUsername("用黄金");
//        user.setPassword(SecurityUtils.md5Hex("123456"));
//        user.setSex(1);
//        user.setIdentitycode("13641050783");
//        user.setEmail("3232315217@qq.com");
//        user.setMobile("1583233515");
//        user.setType(0);
//        boolean num = service.save(user);
//        System.out.println("【"+num+"】");
        INewsService iNewsService = new NewsServiceImpl();
        List<EasybuyNews> newsList =  iNewsService.getAllNewsList();
        for (EasybuyNews news:newsList) {
            System.out.println(news.getContent());
        }
    }
}
