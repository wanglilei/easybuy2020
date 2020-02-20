package com.buy.web;

import com.buy.entity.EasybuyProductCategory;
import com.buy.service.product.IProductCateGoryService;
import com.buy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从service层获取数据
        IProductCateGoryService productCategory = new ProductCategoryServiceImpl();
        List<EasybuyProductCategory> categories = productCategory.queryAllProductCategory("0");

        //存储数据
        request.setAttribute("categoryList",categories);

        //携带数据跳转到home.jsp
        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        doPost(request,response);
    }
}
