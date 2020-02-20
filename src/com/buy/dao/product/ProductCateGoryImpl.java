package com.buy.dao.product;

import com.buy.entity.EasybuyProductCategory;
import com.buy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCateGoryImpl implements IProductCategory {


    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        List<EasybuyProductCategory> productCategries = new ArrayList<EasybuyProductCategory>();
        EasybuyProductCategory productCategory = null;

        try {
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM `easybuy_product_category` where 1=1 ");

            //判断parentID 的值，如果为0，显示的是一级分类
            if (!"".equals(parentId) || null!= parentId){
                sql.append("and parentId = ?");
            }
            //获取连接
            Connection conn = DataSourceUtil.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            if (!"".equals(parentId) && null != parentId) {
                pstmt.setObject(1, parentId);
            }
            //处理结果集
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //实例化对象
                productCategory = new EasybuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentid(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconclass(rs.getString(5));
                //将对象填充到集合中
                productCategries.add(productCategory);
            }

            } catch (Exception e){
                e.printStackTrace();
            }
        return productCategries;


    }
}
