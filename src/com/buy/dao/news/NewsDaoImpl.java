package com.buy.dao.news;

import com.buy.entity.EasybuyNews;
import com.buy.entity.EasybuyUser;
import com.buy.utils.DataSourceUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends DataSourceUtil implements INewDao {
    ResultSet rs;
    public EasybuyNews toTableClass (ResultSet rs) throws SQLException {
        EasybuyNews news = new EasybuyNews();
        news.setId(rs.getInt("id"));
        news.setContent(rs.getString("content"));
        news.setCreatetime(rs.getString("createTime"));
        news.setTitle(rs.getString("title"));
        return news;
    }
    @Override
    public List<EasybuyNews> getAllNewsList() {
        List<EasybuyNews> newsList = new ArrayList<EasybuyNews>();
        EasybuyNews news = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM `easybuy_news`");
            sql.append(" limit 0,5");
            rs = this.executeQuery(sql.toString());
            while (rs.next()){
                news = toTableClass(rs);
                newsList.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newsList;
    }
}
