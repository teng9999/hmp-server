package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.commons.enums.MenuType;
import cn.pl.hmp.commons.enums.SubMenuType;
import cn.pl.hmp.server.business.iface.IMenuChannelBusiness;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTemplet;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTempletExample;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;
import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.mapper.HmpTvMenuTempletMapper;
import cn.pl.hmp.server.dao.mapper.HotelInfoMapper;
import cn.pl.hmp.server.dao.mapper.MenuChannelMapper;
import cn.pl.hmp.server.dao.mapper.MenuPagesMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MenuChannelBusinessImpl extends BoostBusinessImpl implements IMenuChannelBusiness {

    @Autowired
    private MenuChannelMapper mapper;
    @Autowired
    private MenuPagesMapper pagesMapper;
    @Autowired
    private HmpTvMenuTempletMapper menuTempMapper;
    @Autowired
    private HotelInfoMapper hotelMapper;

    @Override
    public int deleteByMenuChannelId(Long id) {
        MenuChannelExample menuExample = new MenuChannelExample();
        menuExample.createCriteria().andPathLike("%"+id+"%");
        List<MenuChannel> menuList = mapper.selectByExample(menuExample);
        if(null != menuList && menuList.size() >0) {
            for(MenuChannel menu:menuList) {
                mapper.deleteByPrimaryKey(menu.getId());
            }
        }
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(MenuChannel record) {
        if (record != null && null != record.getOrderNum()) {
            MenuChannelExample example = new MenuChannelExample();
            example.createCriteria().andParentIdEqualTo(record.getParentId()).andOrderNumEqualTo(record.getOrderNum())
                    .andHotelIdEqualTo(record.getHotelId());
            List<MenuChannel> menuList = mapper.selectByExample(example);
            if (null != menuList && !menuList.isEmpty()) {
                return -2;
            }
        }
        
        String path = "";
        MenuChannel menu = null;
        if(record != null){
            if(record.getParentId() != null)
                menu = mapper.selectByPrimaryKey(record.getParentId());
            if(null == menu) {
                path = record.getParentId()+"";
            }else {
                path = menu.getPath()+"@"+record.getParentId();
            }

            record.setPath(path);

            int res = mapper.insertSelective(record);
            if (res < 0) {
                return -1L;
            }else{
                return record.getId();
            }
        }
        return -1L;
    }

    @Override
    public MenuChannel selectByMenuChannelId(Long id) {
        MenuChannel menu = mapper.selectByMenuId(id);
        if(menu == null ) {
            menu = new MenuChannel();
        }
        return menu;
    }

    @Override
    public List<MenuChannel> selectAll() {
        return mapper.selectByExample(new MenuChannelExample());
    }

    @Override
    public int update(MenuChannel record) {
        if (null != record.getOrderNum()) {
            MenuChannelExample example = new MenuChannelExample();
            example.createCriteria().andParentIdEqualTo(record.getParentId()).andOrderNumEqualTo(record.getOrderNum())
                    .andHotelIdEqualTo(record.getHotelId());
            List<MenuChannel> menuList = mapper.selectByExample(example);
            if (null != menuList && !menuList.isEmpty()) {
                MenuChannel baseChannel = mapper.selectByPrimaryKey(record.getId());
                if (!(null == menuList.get(0).getOrderNum())) {
                    if (baseChannel.getOrderNum().intValue() != menuList.get(0).getOrderNum().intValue()) {
                        return -2;
                    }
                }
            }
        }
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<Pages, List<MenuChannel>> selectByPages(MenuChannelExample example, Pages page) {
        Map<Pages, List<MenuChannel>> map = new HashMap<Pages, List<MenuChannel>>();
        if (null == example)
            example = new MenuChannelExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<MenuChannel> menuChanneList = mapper.selectByExample(example);
        if (null == menuChanneList)
            menuChanneList = new ArrayList<MenuChannel>();
        PageInfo<MenuChannel> pageInfo = new PageInfo<MenuChannel>(menuChanneList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, menuChanneList);
        return map;
    }

    @Override
    public Map<Pages, List<MenuChannel>> queryByParentIdList(Long parentId, Long hotelId, Pages page) {
        Map<Pages, List<MenuChannel>> map = new HashMap<Pages, List<MenuChannel>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<MenuChannel> menuChanneList = mapper.selectByParentIdList(parentId, hotelId);
        if (null == menuChanneList)
            menuChanneList = new ArrayList<MenuChannel>();
        PageInfo<MenuChannel> pageInfo = new PageInfo<MenuChannel>(menuChanneList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, menuChanneList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        // return mapper.deleteOnBatch(idList);
        return 0;
    }

    @Override
    public List<MenuChannel> selectByExample(MenuChannelExample example) {
        if (null == example) {
            return null;
        }
        return mapper.selectByExample(example);
    }

    @Override
    public JSONArray publish(Long hotelId) {
        JSONArray array = new JSONArray();
        if (null == hotelId) {
            return array;
        }
        //全部菜单页面信息
        Map<Long,MenuPages> menuIdPagemap = new HashMap<Long, MenuPages>();
        //酒店下的全部菜单信息
        Map<Long,List<MenuChannel>> parentIdMenumap = new HashMap<Long, List<MenuChannel>>();
        initMenuMap(parentIdMenumap, hotelId);
        initPageMap(menuIdPagemap, hotelId);
        
        List<MenuChannel> topChannelList = parentIdMenumap.get(0L);
        if (null == topChannelList || topChannelList.size() < 1) {
            return array;
        }
        StringBuffer serviceType = new StringBuffer();
        dtreeSaveMassage(array, topChannelList,serviceType,menuIdPagemap,parentIdMenumap);
        return array;
    }
    
    /**
     * 递归保存电视频道
     * 
     * @param topArray
     * @param topChannelList
     */
    public void dtreeSaveMassage(JSONArray topArray, List<MenuChannel> topChannelList,
            StringBuffer serviceType,Map<Long,MenuPages> menuIdPagemap,
            Map<Long,List<MenuChannel>> parentIdMenumap) {
        JSONObject menuChannelObj = null;
        for (MenuChannel menuChannel : topChannelList) {
            menuChannelObj = new JSONObject();
            if (null == menuChannel) {
                continue;
            }
            saveChannel(menuChannelObj, menuChannel,serviceType);
            
            MenuPages menuPages = menuIdPagemap.get(menuChannel.getId());
            JSONObject pagesObj = new JSONObject();
            if (null != menuPages) {
                savePages(menuPages, pagesObj);
            }
            
            JSONArray childArray = new JSONArray();
            menuChannelObj.put("pages", pagesObj);
            menuChannelObj.put("childList", childArray);
            topArray.add(menuChannelObj);
            List<MenuChannel> childList = parentIdMenumap.get(menuChannel.getId());
            if (null != childList && !childList.isEmpty()) {
                dtreeSaveMassage(childArray, childList,serviceType,menuIdPagemap,parentIdMenumap);
            }
        }
    }

    public void saveChannel(JSONObject pObj, MenuChannel pChannel,StringBuffer serviceType) {
        pObj.put("id", pChannel.getId());
        pObj.put("backImg", pChannel.getBackImg());
        pObj.put("menuImg", pChannel.getMenuImg());
        pObj.put("menuType", MenuType.enValuesOf(pChannel.getMenuType()).toIntVal());
        pObj.put("nameCn", pChannel.getNameCn());
        pObj.put("nameEn", pChannel.getNameEn());
        pObj.put("orderNum", pChannel.getOrderNum());
        if(null != pChannel.getServiceType() && !("".equals(pChannel.getServiceType()))) {
            serviceType.delete(0, serviceType.length());
            serviceType.append(pChannel.getServiceType());
        }
        if(serviceType.length() < 1) {
            pObj.put("subMenuType", getSubMenuVal(pChannel.getServiceType()));
        }else {
            pObj.put("subMenuType", getSubMenuVal(serviceType.toString()));
        }
        pObj.put("hotelId", pChannel.getHotelId());
        pObj.put("parentId", pChannel.getParentId());
        pObj.put("propertyType", pChannel.getPropertyYpe()); // 属性类型：食品（0），商品（1）
    }

    public void savePages(MenuPages pages, JSONObject pagesObj) {
        pagesObj.put("backImg", pages.getBackImg());
        pagesObj.put("contentCn", pages.getContentCn());
        pagesObj.put("contentEn", pages.getContentEn());
        pagesObj.put("img", pages.getImg());
        pagesObj.put("imgPosition", pages.getImgPosition());
        pagesObj.put("imgWidth", pages.getImgWidth());
        pagesObj.put("titleCn", pages.getTitleCn());
        pagesObj.put("titleEn", pages.getTitleEn());
    }

    private int getSubMenuVal(String serviceType) {
        if (null == serviceType) {
            return SubMenuType.SERVICE.toIntVal();
        }
        switch (serviceType) {
        case "INFO":
            return SubMenuType.INFO.toIntVal();
        // case APP:
        // return SubMenuType.APP.toIntVal();
        case "ANDROID":
            return SubMenuType.ANDROID.toIntVal();
        case "VIDEO":
            return SubMenuType.VIDEO.toIntVal();
        case "TV":
            return SubMenuType.TV.toIntVal();
        case "AMIBITUSCOLLECT":
            return SubMenuType.AMIBITUSCOLLECT.toIntVal();
        default:
            return SubMenuType.SERVICE.toIntVal();
        }
    }
    
    /**
     * 获取某酒店下的全部菜单信息
     * @param parentIdMenumap
     * @param hotelId
     */
    public void initMenuMap(Map<Long,List<MenuChannel>> parentIdMenumap,
            long hotelId) {
        MenuChannelExample example = new MenuChannelExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        List<MenuChannel> menuList = mapper.selectByExample(example);
        Long parentId = null;
        List<MenuChannel> tempMenuList = null;
        if(null != menuList && !menuList.isEmpty()) {
            for(MenuChannel menu: menuList) {
                if(menu == null ) {
                    continue;
                }
                parentId = menu.getParentId();
                if(parentIdMenumap.containsKey(parentId)) {
                    parentIdMenumap.get(parentId).add(menu);
                }else {
                    tempMenuList = new ArrayList<MenuChannel>();
                    tempMenuList.add(menu);
                    parentIdMenumap.put(parentId, tempMenuList);
                }
            }
        }
    }
    /**
     * 获取某酒店下的全部菜单页面信息
     * @param parentIdMenumap
     * @param hotelId
     */
    public void initPageMap(Map<Long,MenuPages> menuIdPagemap,Long hotelId) {
        List<MenuPages> menuPagesList = pagesMapper.selectByHotel(hotelId);
        if(null != menuPagesList && !menuPagesList.isEmpty()) {
            for(MenuPages menuPages: menuPagesList) {
                if(menuPages == null ) {
                    continue;
                }
                menuIdPagemap.put(menuPages.getMenuId(), menuPages);
            }
        }
    }

    @Override
    public int deleteAllId(Long id) {
        int res = -1;
        MenuChannelExample menuExample = new MenuChannelExample();
        menuExample.createCriteria().andPathLike("%"+id+"%");
        List<MenuChannel> menuList = mapper.selectByExample(menuExample);
        if(null != menuList && menuList.size() >0) {
            for(MenuChannel menu:menuList) {
                res = mapper.deleteByPrimaryKey(menu.getId());
                if (res > 0) {
                    pagesMapper.deleteByChannelId(menu.getId());
                }
            }
        }
        res = mapper.deleteByPrimaryKey(id);
        if (res > 0) {
            pagesMapper.deleteByChannelId(id);
        } 
        return res;
    }

    @Override
    public int synchroMenuOnBatch(String hotelIds) {
        int count = 0;
        List<Long> hotelIdList = new ArrayList<Long>();
        MenuChannelExample menuExample = new MenuChannelExample();
        if(StringUtils.isBlank(hotelIds)) {
            List<HotelInfo> hotelInfoList = hotelMapper.selectByExample(new HotelInfoExample());
            if(null != hotelInfoList && !hotelInfoList.isEmpty()) {
                for(HotelInfo hotel: hotelInfoList) {
                    if(hotel == null) {
                        continue;
                    }
                    hotelIdList.add(hotel.getId());
                }
                
                menuExample.createCriteria().andParentIdEqualTo(0L);
            }
        }else {
            String[] hotelIdArray = hotelIds.split(",");
            for(String hotelId : hotelIdArray) {
                if(StringUtils.isBlank(hotelId)) {
                    continue;
                }
                hotelIdList.add(Long.parseLong(hotelId));
            }
            menuExample.createCriteria().andParentIdEqualTo(0L)
            .andHotelIdIn(hotelIdList);
        }
        
        List<MenuChannel> menuChannelList = mapper.selectByExample(menuExample);
        
        List<MenuChannel> hotelMenuList = null;
        Set<String> hotelMenuNameSet = null;
        Map<Long,List<MenuChannel>> totalHotelMenuMap = new HashMap<Long, List<MenuChannel>>();
        if(null != menuChannelList && ! menuChannelList.isEmpty()) {
            for(MenuChannel menu : menuChannelList) {
                if(totalHotelMenuMap.containsKey(menu.getHotelId())) {
                    totalHotelMenuMap.get(menu.getHotelId()).add(menu);
                }else {
                    hotelMenuList = new ArrayList<MenuChannel>();
                    hotelMenuList.add(menu);
                    totalHotelMenuMap.put(menu.getHotelId(), hotelMenuList);
                    
                }
            }
        }
        
        List<HmpTvMenuTemplet> menuTempList = menuTempMapper.selectByExample(new HmpTvMenuTempletExample());
        Map<String,HmpTvMenuTemplet> tempMenuMap = new HashMap<String, HmpTvMenuTemplet>();
        if(null != menuTempList && ! menuTempList.isEmpty()) {
            for(HmpTvMenuTemplet menu : menuTempList) {
                tempMenuMap.put(menu.getNameCn(), menu);
            }
        }
        
        if(null != hotelIdList && !hotelIdList.isEmpty()) {
            MenuChannel menuChannel = null;
            for(Long hotelId : hotelIdList) {
                if(null == hotelId) {
                    continue;
                }
                //删除与模板不同的一级菜单
                hotelMenuList = totalHotelMenuMap.get(hotelId);
                if(null != hotelMenuList && ! hotelMenuList.isEmpty()) {
                    hotelMenuNameSet = new HashSet<String>();
                    for(MenuChannel tempMenuChannel: hotelMenuList) {
                        
                        if(!tempMenuMap.containsKey(tempMenuChannel.getNameCn())){
                            this.deleteByMenuChannelId(tempMenuChannel.getId());
                        }else {
                            hotelMenuNameSet.add(tempMenuChannel.getNameCn());
                        }
                    }
                }
                
                if(null != menuTempList && ! menuTempList.isEmpty()) {
                    for(HmpTvMenuTemplet menuTemp: menuTempList) {
                        if(null == menuTemp) {
                            continue; 
                        }
                        if(hotelMenuNameSet.add(menuTemp.getNameCn())) {
                            menuChannel = convertMenu(menuTemp, hotelId);
                            mapper.insertSelective(menuChannel);
                        }
                    }
                }
                hotelMenuNameSet.clear();
                count++;
                
            }
        }
        return count;
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
}
