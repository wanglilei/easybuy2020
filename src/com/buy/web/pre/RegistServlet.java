package com.buy.web.pre;

import com.buy.dao.user.IUser;
import com.buy.entity.EasybuyUser;
import com.buy.service.product.IUserService;
import com.buy.service.product.UserServiceImpl;
import com.buy.utils.*;
import com.buy.web.pre.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistServlet",urlPatterns = {"/regist"})
public class RegistServlet extends AbstractServlet {
    IUserService userService;

    @Override
    public void init(){
        userService = new UserServiceImpl();
    }

    @Override
    public Class getServletClass() {
        return RegistServlet.class;
    }


    public String toRegister(HttpServletRequest request, HttpServletResponse response){
        return "/front/regist";
    }

    /**
     * 注册用户
     * @param request
     * @param response
     */
    public ReturnResult doRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ReturnResult result = new ReturnResult();
        //接收前台传过来的用户信息
        String loginName = request.getParameter("loginName");
        //验证用户是否存在
        EasybuyUser olduser = userService.loginByName(loginName);
        if (EmptyUtils.isNotEmpty(olduser)){
            result.returnFail("用户已存在");
            return result;
        }
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        Integer sex =Integer.valueOf(request.getParameter("sex"));
        String idCode = request.getParameter("idCode");
        String mobile = request.getParameter("phone");
        String email = request.getParameter("email");
        //封装用户信息
        EasybuyUser user = new EasybuyUser();
        user.setIdentitycode(idCode);
        user.setMobile(mobile);
        user.setSex(EmptyUtils.isEmpty(sex)?1:0);
        user.setLoginname(loginName);
        user.setEmail(email);
        user.setUsername(userName);
        user.setPassword(SecurityUtils.md5Hex(pwd));
        user.setType(Constants.UserType.PRE);
        //信息校验
        result = this.checkUser(user);
        if (result.getStatus() == Constants.ReturnResult.SUCCESS){
            //注册用户
            boolean flag = userService.save(user);
            if (flag){
                return result.returnSuccess("注册成功！");
            }else {
                return result.returnFail("注册失败！");
            }
        }else {
            return result;
        }
    }

    /**
     * 后端校数据格式
     * @param user
     * @return
     */
    public ReturnResult checkUser(EasybuyUser user){
        ReturnResult result = new ReturnResult();
        //正则表达式验证
        if (EmptyUtils.isNotEmpty(user.getMobile())){
            if  (!RegUtils.checkMobile(user.getMobile())){
                result.returnFail("手机格式不正确");
            }
        }

        if (EmptyUtils.isNotEmpty(user.getMobile())){
            if  (!RegUtils.checkMobile(user.getIdentitycode())){
                result.returnFail("身份证格式不正确");
            }
        }
        if (EmptyUtils.isNotEmpty(user.getMobile())){
            if  (!RegUtils.checkMobile(user.getEmail())){
                result.returnFail("邮箱格式不正确");
            }
        }
        return result.returnSuccess();
    }
}
