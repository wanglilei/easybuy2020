package test;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCateGoryImpl;
import com.buy.entity.EasybuyProductCategory;
import com.buy.service.product.IProductCateGoryService;
import com.buy.service.product.ProductCategoryServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestProductCateGory {
    @Test
    public void testProductCategory(){
        IProductCateGoryService productCategory = new ProductCategoryServiceImpl();
        List<EasybuyProductCategory> productCategories = productCategory.queryAllProductCategory("0");
        for (EasybuyProductCategory category : productCategories){
            System.out.println(category.getName());
        }
    }
}
