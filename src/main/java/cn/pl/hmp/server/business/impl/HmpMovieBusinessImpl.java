package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpMovieBusiness;
import cn.pl.hmp.server.dao.entity.HmpMovie;
import cn.pl.hmp.server.dao.entity.HmpMovieExample;
import cn.pl.hmp.server.dao.mapper.HmpMovieMapper;

/**
 * 
 * @author devpltc 电影资源
 * 
 */
@Service
public class HmpMovieBusinessImpl implements IHmpMovieBusiness {

    @SuppressWarnings("unused")
    private static Logger logger = LoggerFactory.getLogger(HmpMovieBusinessImpl.class);
    @Autowired
    private HmpMovieMapper hmpMovieMapper;

    @Override
    public List<HmpMovie> query(HmpMovieExample example) {
        // TODO Auto-generated method stub
        if (example == null)
            example = new HmpMovieExample();
        return hmpMovieMapper.selectByExample(example);
    }

    @Override
    public Map<Pages, List<HmpMovie>> queryPages(HmpMovieExample example, Pages pages) {
        // TODO Auto-generated method stub
        Map<Pages, List<HmpMovie>> result = new HashMap<>();
        if (example == null)
            example = new HmpMovieExample();
        if (pages == null) {
            List<HmpMovie> list = hmpMovieMapper.selectByExample(example);
            if (list == null)
                list = new ArrayList<HmpMovie>();
            pages = new Pages();
            result.put(pages, list);
        } else {
            PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
            List<HmpMovie> list = hmpMovieMapper.selectByExample(example);
            if (list == null) {
                list = new ArrayList<HmpMovie>();
                result.put(pages, list);
            } else {
                Page<HmpMovie> page = (Page<HmpMovie>) list;
                if (page.getResult() != null && !page.getResult().isEmpty()) {
                    pages.setPageNum(page.getPageNum());
                    pages.setPageSize(page.getPageSize());
                    pages.setSize(page.size());
                    pages.setOrderBy(page.getOrderBy());
                    pages.setEndRow(page.getEndRow());
                    pages.setTotal(page.getTotal());
                    pages.setPages(page.getPages());
                    result.put(pages, page.getResult());
                } else {
                    result.put(pages, new ArrayList<HmpMovie>());
                }
            }

        }
        return result;
    }

    @Override
    public HmpMovie get(Long id) {
        // TODO Auto-generated method stub
        if (0 > id)
            return null;
        return hmpMovieMapper.selectByPrimaryKey(id);

    }

    @Override
    public int create(HmpMovie record) {
        // TODO Auto-generated method stub
        if (record == null || record.getId() == null || 0 > record.getId())
            return 0;
        return hmpMovieMapper.insertSelective(record);
    }

    @Override
    public int update(HmpMovie record) {
        if (record == null || record.getId() == null || 0 > record.getId())
            return 0;
        return hmpMovieMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int remove(Long id) {
        if (null == id || 0 > id)
            return 0;
        return hmpMovieMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<HmpMovie> queryByIds(List<Long> movieIds) {
        // TODO Auto-generated method stub
        if (null == movieIds || movieIds.isEmpty())
            return null;
        return hmpMovieMapper.queryByIds(movieIds);
    }

    @Override
    public List<HmpMovie> queryByHotel(Long hotelId) {
        // TODO Auto-generated method stub
        if (null == hotelId || 0 > hotelId.longValue()) {
            return null;
        }
        System.out.println("hotelId" + hotelId.toString());
        return hmpMovieMapper.queryByHotelId(hotelId);

    }

}
