package com.buy.utils;

import com.buy.entity.EasybuyProduct;

public class ProductParams extends EasybuyProduct {
    //搜索条件
    private String keyWords;
    //排序的列
    private String sort;
    //所属的分类的id
    private Integer categoryId;
    //是否需要分类
    private boolean isPage;
    //从第就条开始显示
    private int startIndex;
    //每页显示多少条
    private int pageSize;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isPage() {
        return isPage;
    }

    public void setPage(boolean page) {
        isPage = page;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void openPage(Integer startIndex,Integer pageSize){
        this.pageSize = startIndex;
        this.pageSize = pageSize;
    }
}
