package cn.pl.hmp.server.utils;

import cn.pl.commons.pages.Pages;

import com.github.pagehelper.PageInfo;

public class PageConverter {
    public static Pages converter(PageInfo pageInfo){
        Pages pages = new Pages();
        pages.setPageNum(pageInfo.getPageNum());
        pages.setPageSize(pageInfo.getPageSize());
        pages.setSize(pageInfo.getSize());
        pages.setOrderBy(pageInfo.getOrderBy());
        pages.setEndRow(pageInfo.getEndRow());
        pages.setTotal(pageInfo.getTotal());
        pages.setPages(pageInfo.getPages());
        return pages;
    }
}
