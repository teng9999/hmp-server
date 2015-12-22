package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.THmpMovie;
import cn.pl.hmp.commons.thrift.service.THmpMovieService.Iface;
import cn.pl.hmp.server.business.iface.IHmpMovieBusiness;
import cn.pl.hmp.server.dao.entity.HmpMovie;
import cn.pl.hmp.server.dao.entity.HmpMovieExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;;

/**
 * 
 * @author devpltc 接口服务
 */
@Component
@ThriftService
public class THmpMovieServiceIface implements Iface {

    @Autowired
    private IHmpMovieBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        // TODO Auto-generated method stub
        if (business == null) {
            return 0;
        }
        if (0 > id)
            return -1;
        return business.remove(id);
    }

    @Override
    public int insert(THmpMovie record) throws TException {
        // TODO Auto-generated method stub
        if (business == null) {
            return 0;
        }
        HmpMovie hmpMovie = ServerTransform.transform(record);
        if (hmpMovie == null) {
            hmpMovie = new HmpMovie();
        }
        return business.insert(hmpMovie);
    }

    @Override
    public THmpMovie selectById(long id) throws TException {
        if (business == null) {
            return null;
        }
        HmpMovie hmpMovie = business.get(id);
        return ServerTransform.transform(hmpMovie);
    }

    @Override
    public int updateById(THmpMovie record) throws TException {
        // TODO Auto-generated method stub
        if (business == null) {
            return 0;
        }
        if (record == null) {
            return 0;
        }
        HmpMovie hmpMovie = ServerTransform.transform(record);
        return business.update(hmpMovie);
    }

    @Override
    public List<THmpMovie> loadAll() throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null) {
            return null;
        }
        List<HmpMovie> lists = business.query(null);
        return listTransform(lists);
    }

    private List<THmpMovie> listTransform(List<HmpMovie> lists) {
        List<THmpMovie> resultLists = new ArrayList<THmpMovie>();
        for (HmpMovie hmpMovie : lists) {
            THmpMovie result = ServerTransform.transform(hmpMovie);
            resultLists.add(result);
        }
        return resultLists;
    }

    @Override
    public Map<TPages, List<THmpMovie>> loadPages(TPages tPages, THmpMovie record) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        Pages pages = ServerTransform.transform(tPages);
        if (pages == null)
            pages = new Pages();
        // 分页查询
        HmpMovieExample example = new HmpMovieExample();
        if (null != record.getNameCn()) {
        	String name = "%" + record.getNameCn() + "%";
        	example.or(example.createCriteria().andAreaLike(name));
            example.or(example.createCriteria().andDirectLike(name));
            example.or(example.createCriteria().andNameCnLike(name));
        }
        if (null != record.getFirstClass())
        	example.createCriteria().andFirstClassEqualTo(record.getFirstClass());
        Map<Pages, List<HmpMovie>> result = business.queryPages(example, pages);
        // 处理查询结果
        Map<TPages, List<THmpMovie>> rtn = new HashMap<>();
        TPages rtnPages = null;
        List<THmpMovie> rtnList = null;
        if (result == null || result.isEmpty()) {
            // 查询结果为空
            rtnPages = new TPages();
            rtnList = new ArrayList<>();
        } else {
            // 查询结果不为空
            for (Pages key : result.keySet()) {
                List<HmpMovie> datas = result.get(key);
                if (datas == null || datas.isEmpty()) {
                    // 查询结果包含的实际数据为空
                    rtnPages = new TPages();
                    rtnList = new ArrayList<>();
                } else {
                    // 转换查询结果和分页对象
                    rtnPages = ServerTransform.transform(key);
                    rtnList = listTransform(datas);
                }
                break;
            }
        }
        rtn.put(rtnPages, rtnList);
        return rtn;
    }

    @Override
    public List<THmpMovie> queryByIds(List<Long> movieIdLists) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null)
            return null;
        if (null == movieIdLists || movieIdLists.isEmpty())
            return null;
        return listTransform(business.queryByIds(movieIdLists));
    }

    @Override
    public List<THmpMovie> queryByHotelId(long hotelId) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null)
            return null;
        if (hotelId > 0)
            return listTransform(business.queryByHotel(hotelId));
        return null;
    }

}
