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
import cn.pl.hmp.commons.thrift.define.THmpMovieGroup;
import cn.pl.hmp.commons.thrift.service.THmpMovieGroupService.Iface;
import cn.pl.hmp.server.business.iface.IHmpMovieGroupBusiness;
import cn.pl.hmp.server.dao.entity.HmpMovieGroup;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THmpMovieGroupServiceIface implements Iface {

    @Autowired
    private IHmpMovieGroupBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return 0;
        if (0 > id)
            return -1;
        return business.remove(id);
    }

    @Override
    public long insert(THmpMovieGroup record) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return 0L;
        if (null == record)
            return -1L;
        HmpMovieGroup hmpMovieGroup = ServerTransform.transform(record);
        if (null == hmpMovieGroup)
            hmpMovieGroup = new HmpMovieGroup();
        return business.create(hmpMovieGroup);
    }

    @Override
    public THmpMovieGroup selectById(long id) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return null;
        if (0 > id)
            return null;
        HmpMovieGroup hmpMovieGroup = business.get(id);
        if (null == hmpMovieGroup)
            hmpMovieGroup = new HmpMovieGroup();
        return ServerTransform.transform(hmpMovieGroup);

    }

    @Override
    public int updateById(THmpMovieGroup record) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return 0;
        if (null == record)
            return -1;
        return business.update(ServerTransform.transform(record));
    }

    @Override
    public List<THmpMovieGroup> loadAll() throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null)
            return null;
        return listTransform(business.query(null));
    }

    @Override
    public Map<TPages, List<THmpMovieGroup>> loadPages(TPages tPages) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        Pages pages = ServerTransform.transform(tPages);
        if (pages == null)
            pages = new Pages();
        // 分页查询
        Map<Pages, List<HmpMovieGroup>> result = business.queryPages(null, pages);
        // 处理查询结果
        Map<TPages, List<THmpMovieGroup>> rtn = new HashMap<>();
        TPages rtnPages = null;
        List<THmpMovieGroup> rtnList = null;
        if (result == null || result.isEmpty()) {
            // 查询结果为空
            rtnPages = new TPages();
            rtnList = new ArrayList<>();
        } else {
            // 查询结果不为空
            for (Pages key : result.keySet()) {
                List<HmpMovieGroup> datas = result.get(key);
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

    private List<THmpMovieGroup> listTransform(List<HmpMovieGroup> lists) {
        List<THmpMovieGroup> resultLists = new ArrayList<THmpMovieGroup>();
        for (HmpMovieGroup hmpMovie : lists) {
            THmpMovieGroup result = ServerTransform.transform(hmpMovie);
            resultLists.add(result);
        }
        return resultLists;
    }

    @Override
    public List<THmpMovieGroup> selectByGroupType(long groupType) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null)
            return null;
        return listTransform(business.selectByGroupType(groupType));
    }

    @Override
    public List<THmpMovieGroup> selectByHotelId(long hotelId) throws ThriftException, TException {
        // TODO Auto-generated method stub
        return null;
    }
}
