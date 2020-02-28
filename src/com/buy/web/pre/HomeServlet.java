package com.buy.web.pre;

import com.buy.entity.EasybuyNews;
import com.buy.entity.EasybuyProductCategory;
import com.buy.service.news.INewsService;
import com.buy.service.news.NewsServiceImpl;
import com.buy.service.product.IProductCateGoryService;
import com.buy.service.product.ProductCategoryServiceImpl;
import com.buy.utils.ProductCategoryVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends AbstractServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //从service层获取数据
//        IProductCateGoryService productCategory = new ProductCategoryServiceImpl();
//        List<EasybuyProductCategory> categories = productCategory.queryAllProductCategory("0");
//
//        //存储数据
//        request.setAttribute("categoryList",categories);
//
//        //携带数据跳转到home.jsp
//        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
//    }
////
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");
//        doPost(request,response);
//    }

    IProductCateGoryService productCategory;
    INewsService iNewsService;
    @Override
    public void init(){
        //从service层获取数据
        productCategory = new ProductCategoryServiceImpl();
        iNewsService = new NewsServiceImpl();
    }
    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategoryVo> categories = productCategory.queryAllProductCategory();
        List<EasybuyNews> newsList = iNewsService.getAllNewsList();
        //存储数据
        request.setAttribute("newsList",newsList);
        request.setAttribute("categoryList",categories);

        //页面跳转
        return "/front/home";
    }

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
}
