package cn.pl.hmp.server.utils;

import com.github.pagehelper.PageInfo;

import cn.pl.commons.pages.Pages;

/**
 * 分页转换
 * 
 * @author renjianwei
 *
 */
public class PageConverter {
    /**
     * 分页信息转换
     * 
     * @param pageInfo
     * @return
     */
    public static Pages converter(PageInfo<?> pageInfo) {
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
