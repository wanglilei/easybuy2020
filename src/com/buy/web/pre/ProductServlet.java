package com.buy.web.pre;

import com.alibaba.druid.sql.parser.Keywords;
import com.buy.entity.EasybuyProduct;
import com.buy.service.product.IProductCateGoryService;
import com.buy.service.product.IProductService;
import com.buy.service.product.ProductCategoryServiceImpl;
import com.buy.service.product.ProductServiceImpl;
import com.buy.utils.EmptyUtils;
import com.buy.utils.Pager;
import com.buy.utils.ProductCategoryVo;
import com.buy.utils.ProductParams;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet" ,urlPatterns = {"/product"})
public class ProductServlet extends AbstractServlet {
    IProductCateGoryService productCategory;
    IProductService productService;
    ProductParams params;
    IProductCateGoryService productCateGoryService;


    /**
     * 实例化
     * @return
     */
    @Override
    public Class getServletClass() {
        return ProductServlet.class;
    }

    @Override
    public void init() throws ServletException{
        //从service层获取数据
        productService = new ProductServiceImpl();
        productCategory = new ProductCategoryServiceImpl();
        productCateGoryService = new ProductCategoryServiceImpl();
        params = new ProductParams();
    }

    protected String queryProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategoryVo> categories = productCategory.queryAllProductCategory();
        request.setAttribute("categoryLists",categories);
        //获取查询条件
        //商品分类
        String categoryId = request.getParameter("categoryId");
        //查询关键字
        String keyWord = request.getParameter("keyWord");
        //分页参数
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        int rowPage = EmptyUtils.isNotEmpty(pageSize)? Integer.valueOf(pageSize) : 8;
        int currentIndex = EmptyUtils.isNotEmpty(currentPage)? Integer.valueOf(currentPage) : 1;
        //封装查询条件
        params.setCategoryId(EmptyUtils.isNotEmpty(categoryId)? Integer.valueOf(categoryId) : null);
        params.setKeyWords(keyWord);
        //分页
        params.openPage((currentIndex-1)*rowPage,rowPage);
        int count = productService.queryProductCount(params);
        //调用分页的工具类
        Pager pager = new Pager(count,rowPage,currentIndex);
        pager.setUrl("/product?action=queryProducts&categoryId="
                +(EmptyUtils.isNotEmpty(categoryId)? categoryId : null)
                + "&keyWord="+keyWord);
        //获取商品的分类信息
        List<ProductCategoryVo> productCategoryVos = productCateGoryService.queryAllProductCategory();
        List<EasybuyProduct> productList = productService.queryProductList(params);

        //存储数据
        request.setAttribute("keyWord", keyWord);
        request.setAttribute("pager", pager);
        request.setAttribute("count", count);
        request.setAttribute("pctList", productList);
        //页面跳转
        return "/front/productList";
    }

//    protected ReturnResult category(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ReturnResult result = new ReturnResult();
//
//        return result;
//    }
}
