package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.commons.utils.AreaUtil;
import cn.pl.hmp.commons.utils.TypeConvert;
import cn.pl.hmp.server.business.iface.IHotelInfoBusiness;
import cn.pl.hmp.server.dao.entity.DataDict;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacks;
import cn.pl.hmp.server.dao.entity.HmpMGExample;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HmpMGHotelExample;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTemplet;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTempletExample;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.entity.HotelRoomType;
import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;
import cn.pl.hmp.server.dao.entity.UserHotel;
import cn.pl.hmp.server.dao.entity.UserHotelExample;
import cn.pl.hmp.server.dao.mapper.DataDictMapper;
import cn.pl.hmp.server.dao.mapper.HmpHotelToolPacksMapper;
import cn.pl.hmp.server.dao.mapper.HmpMGHotelMapper;
import cn.pl.hmp.server.dao.mapper.HmpTvMenuTempletMapper;
import cn.pl.hmp.server.dao.mapper.HotelInfoMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomTypeMapper;
import cn.pl.hmp.server.dao.mapper.MenuChannelMapper;
import cn.pl.hmp.server.dao.mapper.UserHotelMapper;
import cn.pl.hmp.server.dao.mapper.UserMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelInfoBusinessImpl extends BoostBusinessImpl implements IHotelInfoBusiness {

    @Autowired
    private HotelInfoMapper mapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserHotelMapper userHotelMapper;
    @Autowired
    private HmpHotelToolPacksMapper toolPacksMapper;
    @Autowired
    private DataDictMapper dictMapper;
    @Autowired
    private HotelRoomTypeMapper roomTypeMapper;
    @Autowired
    private HmpTvMenuTempletMapper menuTempMapper;
    @Autowired
    private MenuChannelMapper menuChannelMapper;
    @Autowired
    private HmpMGHotelMapper mgHotelMapper;

    @Override
    public int deleteHotelAndUserByHotelId(Long id) {
        UserHotelExample userHotelExample = new UserHotelExample();
        userHotelExample.createCriteria().andHotelIdEqualTo(id);
        List<UserHotel> userHotelList = userHotelMapper.selectByExample(userHotelExample);
        if (null != userHotelList && !userHotelList.isEmpty()) {
            for (UserHotel userHotel : userHotelList) {
                userMapper.deleteByPrimaryKey(userHotel.getUserId());
                userHotelMapper.deleteByPrimaryKey(userHotel.getId());
            }
        }
        toolPacksMapper.deleteByHotelId(id);
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(HotelInfo record) {
        if (null == record) {
            return 0;
        }
        mapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public HotelInfo selectByHotelId(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HotelInfo> selectAll() {
        return mapper.selectByExample(new HotelInfoExample());
    }

    @Override
    public int update(HotelInfo hotelInfo) {
        if (hotelInfo == null || hotelInfo.getId() == null)
            return 0;
        
        HmpMGHotelExample mgExample = new HmpMGHotelExample();
        mgExample.createCriteria().andHotelIdEqualTo(hotelInfo.getId());
        List<HmpMGHotel> mgHotelList = mgHotelMapper.selectByExample(mgExample);
        //电影组
        String movieGroup = hotelInfo.getMovieGroup();
        HmpMGHotel mgHotel = null;
        if (null != movieGroup && !("".equals(movieGroup))) {
            Long movieGroupId = 0L;
            movieGroupId = Long.parseLong(movieGroup);
            if(null == mgHotelList || mgHotelList.isEmpty()) {
                mgHotel = new HmpMGHotel();
                mgHotel.setCreateTime(hotelInfo.getCreateTime());
                mgHotel.setCreator(hotelInfo.getCreator());
                mgHotel.setGroupId(movieGroupId);
                mgHotel.setHotelId(hotelInfo.getId());
                mgHotelMapper.insertSelective(mgHotel);
            }else {
                mgHotel = mgHotelList.get(0);
                mgHotel.setGroupId(movieGroupId);
                mgHotelMapper.updateByPrimaryKey(mgHotel);
            }
        }
        return mapper.updateByPrimaryKeySelective(hotelInfo);
    }

    @Override
    public Map<Pages, List<HotelInfo>> selectByPages(HotelInfoExample example, Pages page) {
        Map<Pages, List<HotelInfo>> map = new HashMap<Pages, List<HotelInfo>>();
        if (null == example)
            example = new HotelInfoExample();
        if(StringUtils.isNotBlank(page.getOrderBy())) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize(),page.getOrderBy());
        }else {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        List<HotelInfo> hotelList = mapper.selectByExample(example);
        if (null == hotelList)
            hotelList = new ArrayList<HotelInfo>();
        PageInfo<HotelInfo> pageInfo = new PageInfo<HotelInfo>(hotelList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, hotelList);
        return map;
    }

    @Override
    public List<HotelInfo> selectByUserId(Long userId) {
        if (null == userId) {
            return null;
        }
        return mapper.selectByUserId(userId);
    }

    @Override
    public JSONObject publish(Long hotelId) {
        HotelInfo hotel = mapper.selectByPrimaryKey(hotelId);
        JSONObject json = new JSONObject();
        if (hotel == null) {
            return json;
        }
        json.put("id", hotel.getId());
        json.put("name", hotel.getName());
        json.put("address", hotel.getAddress());
        json.put("phone", hotel.getPhone());
        json.put("city", hotel.getCity());
        json.put("subName", hotel.getSubName());
        json.put("type", hotel.getType() != null ? TypeConvert.hotelTypeConvert(hotel.getType()) : null);
        json.put("fax", hotel.getFax());
        json.put("bus", hotel.getBus());
        json.put("env", hotel.getEnv());
        json.put("screen", hotel.getScreen() ? "1" : "0");
        json.put("countryCode", hotel.getCountry());
        json.put("cityCode", hotel.getCity());
        json.put("cityName", getCityName(hotel.getProvince(), hotel.getCity()));
        json.put("weatherCode", hotel.getWeatherCode());
        json.put("welcomesCn", hotel.getWelcomesCn());
        json.put("welcomesEn", hotel.getWelcomesEn());
        json.put("cityNameEn", hotel.getCityNameEn());
        json.put("rollCn", hotel.getRollCn());
        json.put("rollEn", hotel.getRollEn());
        return json;
    }

    public String getCityName(String privince, String city) {
        try {
            return AreaUtil.getCityName(privince, city);
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public HotelInfo selectListWithUserByHotelId(Long hotelId) {
        HotelInfo hotel = mapper.selectListWithUserByHotelId(hotelId);
        if (hotel == null) {
            hotel = new HotelInfo();
        }
        return hotel;
    }

    @Override
    public long saveAll(HotelInfo hotelInfo, User user) {
        
        if(StringUtils.isNotBlank(hotelInfo.getChainId())) {
            HotelInfoExample hotelExample = new HotelInfoExample();
            hotelExample.createCriteria().andChainIdEqualTo(hotelInfo.getChainId());
            List<HotelInfo> hotelList = mapper.selectByExample(hotelExample);
            if(null != hotelList && !hotelList.isEmpty()) {
                return -100;
            }
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> userList = userMapper.selectByExample(userExample);
        if(null != userList && !userList.isEmpty()) {
            return -200;
        }
        
        mapper.insertSelective(hotelInfo);
        long hotelRes = hotelInfo.getId();
        userMapper.insertSelective(user);
        Long userRes = user.getId();
        if (userRes > 0 && hotelRes > 0) {
            UserHotel userHotel = new UserHotel();
            userHotel.setUserId(user.getId());
            userHotel.setHotelId(hotelInfo.getId());
            userHotel.setCreateTime(hotelInfo.getCreateTime());
            userHotel.setCreator(hotelInfo.getCreator());
            userHotelMapper.insert(userHotel);
        }
        //电影组
        String movieGroup = hotelInfo.getMovieGroup();
        if (null != movieGroup && !("".equals(movieGroup))) {
            Long MovieGroupId = 0L;
            MovieGroupId = Long.parseLong(movieGroup);
            HmpMGHotel mgHotel = new HmpMGHotel();
            mgHotel.setCreateTime(hotelInfo.getCreateTime());
            mgHotel.setCreator(hotelInfo.getCreator());
            mgHotel.setGroupId(MovieGroupId);
            mgHotel.setHotelId(hotelInfo.getId());
            mgHotelMapper.insertSelective(mgHotel);
        }
        //添加酒店安装包信息
        HmpHotelToolPacks tookPacks = new HmpHotelToolPacks();
        tookPacks.setCreateDate(new Date());
        tookPacks.setCurVersion("");
        tookPacks.setHotelId(hotelRes);
        
        List<DataDict> dictList = dictMapper.selectByParentName("PKGType");
        tookPacks.setPkgType("1");
        toolPacksMapper.insertSelective(tookPacks);
        if(null != dictList && !dictList.isEmpty()) {
            for(DataDict dict : dictList) {
                tookPacks.setId(null);
                tookPacks.setPkgType(dict.getName());
                toolPacksMapper.insertSelective(tookPacks);
            }
        }
      //添加默认房间类型
        List<String> typeNameList = new ArrayList<String>();
        typeNameList.add("经济房");
        typeNameList.add("传统大床房");
        typeNameList.add("自主大床房");
        typeNameList.add("商务大床房");
        typeNameList.add("商务双床房");
        typeNameList.add("豪华大床房");
        typeNameList.add("豪华双床房");
        HotelRoomType roomType = new HotelRoomType();
        roomType.setCreateTime(new Date());
        roomType.setHotelId(hotelRes);
        for(String typeName : typeNameList ) {
            roomType.setId(null);
            roomType.setName(typeName);
            roomTypeMapper.insertSelective(roomType);
        }
        //添加默认菜单模板
        MenuChannel menuChannel = null;
        List<HmpTvMenuTemplet> menuTempList = menuTempMapper.selectByExample(new HmpTvMenuTempletExample());
        if(null != menuTempList && ! menuTempList.isEmpty()) {
            for(HmpTvMenuTemplet menuTemp: menuTempList) {
                if(null == menuTemp) {
                    continue;
                }
                menuChannel = convertMenu(menuTemp, hotelRes);
                if(null != menuChannel) {
                    menuChannelMapper.insertSelective(menuChannel);
                }
            }
        }
        return user.getId();
    }
    
    private MenuChannel convertMenu(HmpTvMenuTemplet menuTemp,Long hotelId) {
        MenuChannel menuChannel = new MenuChannel();
        menuChannel.setBackImg(menuTemp.getBackImg());
        menuChannel.setBrandId(menuTemp.getBrandId());
        menuChannel.setBreedId(menuTemp.getBreedId());
        menuChannel.setMenuImg(menuTemp.getMenuImg());
        menuChannel.setIsProperty(menuTemp.getIsProperty());
        menuChannel.setMenuType(menuTemp.getMenuType());
        menuChannel.setNameCn(menuTemp.getNameCn());
        menuChannel.setNameEn(menuTemp.getNameEn());
        menuChannel.setOrderNum(menuTemp.getOrderNum());
        menuChannel.setOrgId(menuTemp.getOrgId());
        //menuChannel.setParentId(menuTemp.getParentId());
        menuChannel.setParentId(0L);
        //menuChannel.setPath(menuTemp.getPath());
        menuChannel.setPath("0");
        menuChannel.setPropertyYpe(menuTemp.getPropertyType());
        menuChannel.setServiceType(menuTemp.getServiceType());
        menuChannel.setSubMenuType(menuTemp.getSubMenuType());
        menuChannel.setSysId(menuTemp.getSysId());
        menuChannel.setHotelId(hotelId);
        return menuChannel;
    }

    @Override
    public Map<Pages, List<HotelInfo>> selectByPagesWithUser(Pages page,
            String province, String name, String condition) {
        Map<Pages, List<HotelInfo>> map = new HashMap<Pages, List<HotelInfo>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<HotelInfo> hotelList = mapper.selectListWithUser(province, name, condition);
        if (null == hotelList)
            hotelList = new ArrayList<HotelInfo>();
        PageInfo<HotelInfo> pageInfo = new PageInfo<HotelInfo>(hotelList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, hotelList);
        return map;
    }
}
