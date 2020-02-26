package com.buy.web.pre;

import com.buy.entity.EasybuyUser;
import com.buy.service.product.IUserService;
import com.buy.service.product.UserServiceImpl;
import com.buy.utils.EmptyUtils;
import com.buy.utils.ReturnResult;
import com.buy.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet" ,urlPatterns = {"/login"})
public class LoginServlet extends AbstractServlet {
    IUserService userService;
    /**
     * 实例化
     * @return
     */
    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }


    @Override
    public void init() throws ServletException{
        //从service层获取数据
        userService = new UserServiceImpl();
    }

    /**
     * 登陆方法
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String toLogin(HttpServletRequest request, HttpServletResponse response){
        return "/front/login";
    }
    public ReturnResult login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ReturnResult result = new ReturnResult();
        //获取用户登陆的用户名密码
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        //根据loginname获取用户对象
        EasybuyUser user = userService.loginByName(loginName);
        if (EmptyUtils.isEmpty(user)){
            result.returnFail("用户不存在！");
        }else{
            //比较用户的信息
            if (user.getPassword().equals(SecurityUtils.md5Hex(password))){
                request.getSession().setAttribute("loginUser",user);
                result.returnSuccess("登陆成功！");
            }else {
                result.returnFail("密码错误！");
            }
        }
        return result;
    }

    /**
     * 用户注销
     * @param request
     * @param response
     * @return
     * @throws SQLException
     */
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ReturnResult result = new ReturnResult();
        //删除session用户的记录
        request.getSession().removeAttribute("loginUser");


//        //返回结果
//        result.returnSuccess("注销成功！");

//        return "/home?action=index";
        return "/front/home";
    }
}
