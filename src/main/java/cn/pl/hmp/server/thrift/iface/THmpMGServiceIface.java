package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.THmpMG;
import cn.pl.hmp.commons.thrift.service.THmpMGService.Iface;
import cn.pl.hmp.server.business.iface.IHmpMGBusiness;
import cn.pl.hmp.server.dao.entity.HmpMG;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THmpMGServiceIface implements Iface {

    @Autowired
    private IHmpMGBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return -1;
        if (0 > id)
            return 0;
        return business.remove(id);
    }

    @Override
    public int insert(THmpMG record) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return -1;
        if (null == record)
            return 0;
        HmpMG entity = ServerTransform.transform(record);
        if (null == entity)
            return 0;
        return business.create(entity);
    }

    @Override
    public THmpMG selectById(long id) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return new THmpMG();
        if (0 > id)
            return new THmpMG();
        HmpMG entity = business.get(id);
        if (null == entity)
            return new THmpMG();
        return ServerTransform.transform(entity);
    }

    @Override
    public int updateById(THmpMG record) throws TException {
        // TODO Auto-generated method stub
        if (null == business)
            return -1;
        if (null == record || 0 < record.getId())
            return 0;
        return business.update(ServerTransform.transform(record));
    }

    @Override
    public List<THmpMG> loadAll() throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (null == business)
            return null;
        List<HmpMG> lists = business.query(null);
        if (null == lists || 0 < lists.size())
            return new ArrayList<THmpMG>();
        return listTransform(lists);

    }

    @Override
    public List<Long> selectByGroupId(long groupId) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (0 > groupId)
            return new ArrayList<Long>();
        List<Long> lists = business.queryByGroupId(groupId);
        if (null == lists || 0 >= lists.size())
            return new ArrayList<Long>();
        return lists;
    }

    @Override
    public Map<TPages, List<THmpMG>> loadPages(TPages tPages) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        // Pages pages = ServerTransform.transform(tPages);
        // if (pages == null)
        // pages = new Pages();
        // 分页查询

        return null;
    }

    private List<THmpMG> listTransform(List<HmpMG> lists) {
        List<THmpMG> resultLists = new ArrayList<THmpMG>();
        for (HmpMG hmpMG : lists) {
            THmpMG result = ServerTransform.transform(hmpMG);
            resultLists.add(result);
        }
        return resultLists;
    }

    private List<HmpMG> listTrans(List<THmpMG> lists) {
        List<HmpMG> resultLists = new ArrayList<HmpMG>();
        for (THmpMG hmpMG : lists) {
            HmpMG result = ServerTransform.transform(hmpMG);
            resultLists.add(result);
        }
        return resultLists;
    }

    @Override
    public int saveOnBatch(List<THmpMG> mgList) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (null == mgList || mgList.isEmpty())
            return -1;
        return business.saveOnBatch(listTrans(mgList));
    }

    @Override
    public int deleteOnBatch(List<Long> idList, long groupId) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (null == idList || idList.isEmpty())
            return -1;
        return business.deleteOnBatch(idList, groupId);

    }

    @Override
    public int deleteByGroupIdOnBatch(long groupId) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (0 > groupId)
            return -1;
        return business.deleteByGroupIdOnBatch(groupId);
    }

    @Override
    public List<Long> queryByGroupIdLists(List<Long> groupIdLists) throws ThriftException, TException {
        // TODO Auto-generated method stub
        if (null == groupIdLists || groupIdLists.isEmpty())
            return null;
        return business.queryByGroupIdLists(groupIdLists);
    }

}
