package com.buy.web.pre;

import com.buy.utils.EmptyUtils;
import com.buy.utils.PrintUtil;
import com.buy.utils.ReturnResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "AbstractServlet" )
public abstract class AbstractServlet extends HttpServlet {
    //用来获取servlet对象实例
    public abstract Class getServletClass();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Method method = null;
        Object result = null;
        try {
            //根据action参数来决定页面的跳转情况
            if (EmptyUtils.isEmpty(action)){
                //如果参数为空，跳转的首页
                result = execute(request,response);
            }else {
                //有参数的处理方式
                method = getServletClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
                result = method.invoke(this, request, response);
            }
            toView(result,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            String viewName = "404.jsp";
            request.getRequestDispatcher(viewName).forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            if (!EmptyUtils.isEmpty(result)){
                if (result instanceof String ){
                    String viewName = "500.jsp";
                    request.getRequestDispatcher(viewName).forward(request,response);
                }else{
                    ReturnResult returnResult = new ReturnResult();
                    returnResult.returnFail("系统错误！");
                    PrintUtil.write(returnResult,response);
                }
            }else{
                String viewName = "500.jsp";
                request.getRequestDispatcher(viewName).forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 根据servlet调用的返回结果决定下一步是放回jsp页面
     * @param result
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toView(Object result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(!EmptyUtils.isEmpty(result)){
            //判断result是不是json数据如果不是，则加后缀jsp
            if (result instanceof String){
                String viewName = result.toString()+".jsp";
                request.getRequestDispatcher(viewName).forward(request,response);
            }else   {
                //返回的是json 数据
                PrintUtil.write(result,response);
            }
        }
    }

    public Object execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        return "/front/home";
    }
















}
