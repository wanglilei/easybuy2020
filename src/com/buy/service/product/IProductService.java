package com.buy.service.product;

import com.buy.entity.EasybuyProduct;
import com.buy.utils.ProductParams;

import java.util.List;

public interface IProductService {
    /**
     * 根据条件查询商品列表
     * @param params
     * @return
     */
    List<EasybuyProduct> queryProductList(ProductParams params);

    /**
     * 根据条件查询商品的数量
     * @param params
     * @return
     */
    int queryProductCount(ProductParams params);
}
