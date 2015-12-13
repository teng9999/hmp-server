package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpMGBusiness;
import cn.pl.hmp.server.dao.entity.HmpMG;
import cn.pl.hmp.server.dao.entity.HmpMGExample;
import cn.pl.hmp.server.dao.mapper.HmpMGMapper;

/***
 * 电影分组与影片对应业务处理
 * 
 * @author devpltc
 *
 */
@Service
public class HmpMGBusinessImpl implements IHmpMGBusiness {

    @Autowired
    private HmpMGMapper hmpMGMapper;

    @Override
    public List<HmpMG> query(HmpMGExample example) {
        // TODO Auto-generated method stub
        if (null == example)
            example = new HmpMGExample();
        return hmpMGMapper.selectByExample(example);
    }

    @Override
    public Map<Pages, List<HmpMG>> queryPages(HmpMGExample example, Pages pages) {
        // TODO Auto-generated method stub
        Map<Pages, List<HmpMG>> result = new HashMap<>();
        if (null == example)
            example = new HmpMGExample();
        if (null == pages) {
            List<HmpMG> list = hmpMGMapper.selectByExample(example);
            if (null == list)
                list = new ArrayList<HmpMG>();
            pages = new Pages();
            result.put(pages, list);
        } else {
            PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
            List<HmpMG> list = hmpMGMapper.selectByExample(example);
            if (null == list) {
                list = new ArrayList<HmpMG>();
                result.put(pages, list);
            } else {
                Page<HmpMG> page = (Page<HmpMG>) list;
                if (null != page.getResult() && !page.getResult().isEmpty()) {
                    pages.setPageNum(page.getPageNum());
                    pages.setPageSize(page.getPageSize());
                    pages.setSize(page.size());
                    pages.setOrderBy(page.getOrderBy());
                    pages.setEndRow(page.getEndRow());
                    pages.setTotal(page.getTotal());
                    pages.setPages(page.getPages());
                    result.put(pages, page.getResult());
                } else {
                    result.put(pages, new ArrayList<HmpMG>());
                }
            }
        }
        return result;
    }

    @Override
    public HmpMG get(Long id) {
        // TODO Auto-generated method stub
        if (0 > id)
            return new HmpMG();
        return hmpMGMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(HmpMG record) {
        // TODO Auto-generated method stub
        if (null == record || null != record.getId())
            return 0;
        if (null == record.getMovieId() || 0 > record.getGroupId().longValue() || null == record.getGroupId()
                || 0 > record.getMovieId().longValue())
            return 0;
        return hmpMGMapper.insertSelective(record);
    }

    @Override
    public int update(HmpMG record) {
        // TODO Auto-generated method stub
        if (null == record)
            return -1;
        if (null == record.getId() || 0 > record.getId().longValue())
            return 0;
        return hmpMGMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int remove(Long id) {
        // TODO Auto-generated method stub
        if (null == id || 0 > id.longValue())
            return -1;
        return hmpMGMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Long> queryByGroupId(Long groupId) {
        // TODO Auto-generated method stub
        if (null == groupId || 0 > groupId.longValue())
            return new ArrayList<Long>();
        List<Long> lists = hmpMGMapper.queryByGroupId(groupId);
        if (null == lists || lists.isEmpty())
            return new ArrayList<Long>();
        return lists;
    }

    @Override
    public int saveOnBatch(List<HmpMG> mgList) {
        // TODO Auto-generated method stub
        if (null == mgList || mgList.isEmpty())
            return 0;

        return hmpMGMapper.insertBatch(mgList);
    }

    @Override
    public int deleteOnBatch(List<Long> movieIdList, Long groupId) {
        // TODO Auto-generated method stub
        if (null == groupId || 0 > groupId.longValue())
            return 0;
        if (null == movieIdList || movieIdList.isEmpty())
            return 0;
        return hmpMGMapper.deleteBatch(movieIdList, groupId);
    }

    @Override
    public int deleteByGroupIdOnBatch(Long groupId) {
        // TODO Auto-generated method stub
        if (null == groupId || 0 > groupId.longValue())
            return 0;
        return hmpMGMapper.deleteBatchByGroupId(groupId);

    }

    @Override
    public List<Long> queryByGroupIdLists(List<Long> groupId) {
        if (null == groupId || groupId.isEmpty())
            return null;
        return hmpMGMapper.queryByGroupIdLists(groupId);
    }
}
