package com.buy.service.product;

import com.buy.dao.product.IProductDao;
import com.buy.dao.product.ProductImpl;
import com.buy.entity.EasybuyProduct;
import com.buy.utils.ProductParams;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    IProductDao productDao = new ProductImpl();
    @Override
    public List<EasybuyProduct> queryProductList(ProductParams params) {
        return productDao.queryProductList(params);
    }

    @Override
    public int queryProductCount(ProductParams params) {
        return productDao.queryProductCount(params);
    }
}
