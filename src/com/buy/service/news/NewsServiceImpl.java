package com.buy.service.news;

import com.buy.dao.news.INewDao;
import com.buy.dao.news.NewsDaoImpl;
import com.buy.entity.EasybuyNews;

import java.util.List;

public class NewsServiceImpl implements INewsService {
    INewDao iNewDao = new NewsDaoImpl();
    @Override
    public List<EasybuyNews> getAllNewsList() {
        return iNewDao.getAllNewsList();
    }
}
