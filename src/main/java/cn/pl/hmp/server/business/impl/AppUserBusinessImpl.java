package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.security.AesUtil;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.AbstractBusiness;
import cn.pl.hmp.server.business.iface.IAppUserBusiness;
import cn.pl.hmp.server.dao.entity.AppUser;
import cn.pl.hmp.server.dao.entity.AppUserExample;
import cn.pl.hmp.server.dao.mapper.AppUserMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class AppUserBusinessImpl extends AbstractBusiness implements
        IAppUserBusiness {
    @Autowired
    private AppUserMapper mapper;

    @Override
    public int delete(Long id) {
        if (null == id) {
            return 0;
        }
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(AppUser record) {
        if (null != record) {
            int res = mapper.insertSelective(record);
            if (res > 0) {
                return record.getId();
            } else {
                return -1L;
            }
        }
        return 0;
    }

    @Override
    public AppUser selectById(Long id) {
        if (null == id) {
            return null;
        }
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public AppUser selectByUserName(String credNum,String name) {
        if (null != credNum) {
            AppUserExample example = new AppUserExample();
            example.createCriteria().andCredNumEqualTo(credNum).andNameEqualTo(name);
            List<AppUser> userList = mapper.selectByExample(example);
            if(null != userList && !userList.isEmpty()) {
                return userList.get(0);
            }
        }
        return new AppUser();
    }

    @Override
    public int update(AppUser record) {
        if (null != record) {
            return mapper.updateByPrimaryKeySelective(record);
        }
        return 0;
    }

    @Override
    public List<AppUser> selectAll() {
        AppUserExample example = new AppUserExample();
        return mapper.selectByExample(example);
    }

    @Override
    public Map<Pages, List<AppUser>> selectByPages(AppUserExample example,
            Pages page) {
        Map<Pages, List<AppUser>> map = new HashMap<Pages, List<AppUser>>();
        if (null == example)
            example = new AppUserExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<AppUser> userList = mapper.selectByExample(example);
        if (null == userList)
            userList = new ArrayList<AppUser>();
        PageInfo<AppUser> pageInfo = new PageInfo<AppUser>(userList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, userList);
        return map;
    }

    @Override
    public int resetPasswordByCred(String password, int credType, String credNum) {
        if(StringUtils.isBlank(password) || 
                credType < 1 || StringUtils.isBlank(credNum)) {
            return 0;
        }
        AppUserExample example = new AppUserExample();
        example.createCriteria().andCredNumEqualTo(credNum).andCredTypeEqualTo(credType);
        List<AppUser> list = mapper.selectByExample(example);
        if(null !=list && !list.isEmpty()) {
            AppUser user = list.get(0);
            
            String salt;
            try {
                AesUtil des = new AesUtil();// 自定义密钥
                salt = des.encrypt(password);//秘钥
                user.setPassword(salt+":"+user.getPassword());
                return mapper.updateByPrimaryKeySelective(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
