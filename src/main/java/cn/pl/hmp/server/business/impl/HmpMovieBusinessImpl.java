package cn.pl.hmp.server.business.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpMovieBusiness;
import cn.pl.hmp.server.dao.entity.HmpMovie;
import cn.pl.hmp.server.dao.entity.HmpMovieExample;
import cn.pl.hmp.server.dao.mapper.HmpMovieMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
            List<HmpMovie> list = hmpMovieMapper.selectByExampleWithBLOBs(example);
            if (list == null)
                list = new ArrayList<HmpMovie>();
            pages = new Pages();
            result.put(pages, list);
        } else {
            PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
            List<HmpMovie> list = hmpMovieMapper.selectByExampleWithBLOBs(example);
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
    public int insert(HmpMovie record) {
        // TODO Auto-generated method stub
        if (record == null)
            return 0;
        int rlt = hmpMovieMapper.insertSelective(record);
        if (rlt > 0) {
            return record.getId().intValue();
        }
        return -1;
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
        return hmpMovieMapper.queryByHotel(hotelId, null);

    }

    @Override
    public JSONArray publish(Long hotelId) {
        JSONArray array = new JSONArray();
        List<HmpMovie> movieList = this.queryByHotel(hotelId);
        if(null == movieList || movieList.isEmpty()) {
            return array;
        }
        JSONObject movieTemp = null;
        String[] tempStr = null;
        for(HmpMovie movie: movieList) {
            if(null == movie) {
                continue;
            }
            tempStr = parseFile(movie.getPath());
            if(null == tempStr || tempStr.length != 3) {
                continue;
            }
            movieTemp = new JSONObject();
            movieTemp.put("name", movie.getNameCn());
            movieTemp.put("nameEn", movie.getNameEn());
            movieTemp.put("dir", tempStr[0]);
            movieTemp.put("file", tempStr[1]);
            movieTemp.put("suffix", tempStr[2]);
            
            movieTemp.put("type", 1);
            movieTemp.put("playCount", 20);
            movieTemp.put("movieId", movie.getId());
            movieTemp.put("num", 1);
            //movieTemp.put("price", 0);
            
            movieTemp.put("backImg", movie.getBackImg());
            movieTemp.put("backImgSmall", movie.getBackImgSmall());
            array.add(movieTemp);
        }
        return array;
    }
    
    private String[] parseFile(String fn){
        if(null == fn)
            return null;
        File file = new File(fn);
        
        String[] str = new String[3];
        
        str[0] = file.getParent() + File.separator;
        String n = file.getName();
        int index = -1;
        
        if((index = n.lastIndexOf(".")) < 0){
            str[1] = "xxx";
            str[2] = "xxx";
        }else{
            str[1] = n.substring(0,index);
            str[2] = n.substring(index + 1);
        }
        return str;
    }

    @Override
    public Map<Pages, List<HmpMovie>> selectPagesByHotel(Pages page, Long hotelId,String name) {
        Map<Pages, List<HmpMovie>> map = new HashMap<Pages, List<HmpMovie>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<HmpMovie> hotelMovieList = hmpMovieMapper.queryByHotel(hotelId, name);
        if (null == hotelMovieList)
            hotelMovieList = new ArrayList<HmpMovie>();
        PageInfo<HmpMovie> pageInfo = new PageInfo<HmpMovie>(hotelMovieList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelMovieList);
        return map;// TODO Auto-generated method stub
    }

}
