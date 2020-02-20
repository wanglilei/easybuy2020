package com.buy.service.product;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCateGoryImpl;
import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public class ProductCategoryServiceImpl implements IProductCateGoryService {
    private IProductCategory productCategory = new ProductCateGoryImpl();
    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        parentId = "0";
        return productCategory.queryAllProductCategory(parentId);
    }
}
