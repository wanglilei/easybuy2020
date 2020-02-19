package test;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCateGoryImpl;
import com.buy.entity.EasybuyProductCategory;
import org.junit.Test;

import java.util.List;

public class TestProductCateGory {
    @Test
    public void testProductCategory(){
        IProductCategory productCategory = new ProductCateGoryImpl();
        List<EasybuyProductCategory> productCategories = productCategory.queryAllProductCategory("0");
        for (EasybuyProductCategory category : productCategories){
            System.out.println(category.getName());
        }
    }
}
