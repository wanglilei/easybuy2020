package com.buy.dao.product;

import com.buy.entity.EasybuyProduct;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.EmptyUtils;
import com.buy.utils.ProductParams;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl extends DataSourceUtil implements IProductDao{
    public EasybuyProduct toTableClass(ResultSet rs) throws SQLException {
        EasybuyProduct product = new EasybuyProduct();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("Name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getString("price"));
        product.setStock(rs.getInt("stock"));
        product.setCategorylevel1id(rs.getInt("categoryLevel1Id"));
        product.setCategorylevel2id(rs.getInt("categoryLevel2Id"));
        product.setCategorylevel3id(rs.getInt("categoryLevel3Id"));
        product.setFilename(rs.getString("fileName"));
        product.setIsdelete(rs.getInt("isDelete"));
        return product;
    }


    @Override
    public List<EasybuyProduct> queryProductList(ProductParams params) {
        List<EasybuyProduct> productList = new ArrayList<EasybuyProduct>();
        ResultSet rs = null;
        try {
            //编写SQL语句
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easybuy_product WHERE 1=1");

            //1、判断参数，设置不同的查询条件
            if  (EmptyUtils.isNotEmpty(params.getKeyWords())){
                sql.append(" and name like ?");
                rs = this.executeQuery(sql.toString(), "%"+params.getKeyWords()+"%");

            //2、分类查询
            }else if (EmptyUtils.isNotEmpty(params.getCategoryId())){
                sql.append(" and (categoryLevel1Id = ? or categoryLevel2Id = ? or categoryLevel3Id = ?)");
                rs = this.executeQuery(sql.toString(),params.getCategoryId(),params.getCategoryId(),params.getCategoryId());

            //3、排序
            } else if (EmptyUtils.isNotEmpty(params.getSort())){
                sql.append( " order by ?");
                rs = this.executeQuery(sql.toString(),params.getSort());

            //4、分页
            }else if  (EmptyUtils.isNotEmpty(params.isPage())){
                sql.append( " limit ?, ?");
                rs = this.executeQuery(sql.toString(),params.getStartIndex(),params.getPageSize());
            }
            //执行查询
            while (rs.next()){
                EasybuyProduct product =  this.toTableClass(rs);
                productList.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public int queryProductCount(ProductParams params) {
        Integer num = 0;
        ResultSet rs = null;
            try {
            //编写SQL语句
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) from easybuy_product where 1=1");
            //判断参数，设置不同的查询条件
            if (EmptyUtils.isNotEmpty(params.getKeyWords())) {//1、模糊查询
                sql.append(" and name like ?");
                rs = this.executeQuery(sql.toString(), "%" + params.getKeyWords() + "%");
            } else if (EmptyUtils.isNotEmpty(params.getCategoryId())) {//2、分类查询
                sql.append(" and categoryLevel1Id =? or categoryLevel2Id=? or categoryLevel3Id=?");
                rs = this.executeQuery(sql.toString(), params.getCategoryId(), params.getCategoryId(), params.getCategoryId());
            } else if (EmptyUtils.isNotEmpty(params.getSort())) {//3、排序
                sql.append(" order by ?");
                rs = this.executeQuery(sql.toString(), params.getSort());
            } else if (EmptyUtils.isNotEmpty(params.isPage())) {//4、分页
                sql.append(" limit ?, ?");
                rs = this.executeQuery(sql.toString(), params.getStartIndex(), params.getPageSize());
            }
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            num = -1;
        }
            return num;
        }
//    Integer num = 0;
//    ResultSet rs = null;
//        try {
//        //编写SQL语句
//        StringBuffer sql = new StringBuffer();
//        sql.append("select count(1) from easybuy_product where 1=1");
//        //判断参数，设置不同的查询条件
//        if (EmptyUtils.isNotEmpty(params.getKeyWords())) {//1、模糊查询
//            sql.append(" and name like ?");
//            rs = this.executeQuery(sql.toString(), "%" + params.getKeyWords() + "%");
//        } else if (EmptyUtils.isNotEmpty(params.getCategoryId())) {//2、分类查询
//            sql.append(" and categoryLevel1Id =? or categoryLevel2Id=? or categoryLevel3Id=?");
//            rs = this.executeQuery(sql.toString(), params.getCategoryId(), params.getCategoryId(), params.getCategoryId());
//        } else if (EmptyUtils.isNotEmpty(params.getSort())) {//3、排序
//            sql.append(" order by ?");
//            rs = this.executeQuery(sql.toString(), params.getSort());
//        } else if (EmptyUtils.isNotEmpty(params.isPage())) {//4、分页
//            sql.append(" limit ?, ?");
//            rs = this.executeQuery(sql.toString(), params.getStartIndex(), params.getPageSize());
//        }
//        if (rs.next()) {
//            num = rs.getInt(1);
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//        num = -1;
//    }
//        return num;
//}

}
