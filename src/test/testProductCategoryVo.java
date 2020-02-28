package test;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCateGoryImpl;
import com.buy.service.product.IProductCateGoryService;
import com.buy.service.product.ProductCategoryServiceImpl;
import com.buy.utils.ProductCategoryVo;
import org.junit.Test;

import java.util.List;

public class testProductCategoryVo {
    @Test
    public static void main(String[] args) {
        IProductCateGoryService productCateGory = new ProductCategoryServiceImpl();
        List<ProductCategoryVo>  productCategoryVos = productCateGory.queryAllProductCategory();
        System.out.println(productCategoryVos.size());
//        for (ProductCategoryVo categoryVo:productCategoryVos) {
//            System.out.println(categoryVo.getProductCategory());
//        }
    }
}
