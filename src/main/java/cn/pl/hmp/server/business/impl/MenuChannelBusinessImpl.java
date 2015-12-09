package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.commons.enums.roomRcu.MenuType;
import cn.pl.hmp.commons.enums.roomRcu.SubMenuType;
import cn.pl.hmp.server.business.iface.IMenuChannelBusiness;
import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;
import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.mapper.MenuChannelMapper;
import cn.pl.hmp.server.dao.mapper.MenuPagesMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MenuChannelBusinessImpl extends BoostBusinessImpl implements IMenuChannelBusiness{

	@Autowired
	private MenuChannelMapper mapper;
	@Autowired
	private MenuPagesMapper pagesMapper;

	@Override
	public int deleteByMenuChannelId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(MenuChannel record) {
	    if(null != record.getOrderNum() && !"".equals(record.getOrderNum())) {
	        MenuChannelExample example = new MenuChannelExample();
	        example.createCriteria().andParentIdEqualTo(record.getParentId())
	        .andOrderNumEqualTo(record.getOrderNum())
	        .andHotelIdEqualTo(record.getHotelId());
	        List<MenuChannel> menuList = mapper.selectByExample(example);
	        if(null != menuList && !menuList.isEmpty()) {
	            return -2;
	        }
	    }
	    int res = mapper.insertSelective(record);
	    if(res < 0 ) {
	        return -1L;
	    }
		return record.getId();
	}

	@Override
	public MenuChannel selectByMenuChannelId(Long id) {
		return mapper.selectByMenuId(id);
	}

	@Override
	public List<MenuChannel> selectAll() {
		return mapper.selectByExample(new MenuChannelExample());
	}

	@Override
	public int update(MenuChannel record) {
	    if(null != record.getOrderNum()) {
            MenuChannelExample example = new MenuChannelExample();
            example.createCriteria().andParentIdEqualTo(record.getParentId())
            .andOrderNumEqualTo(record.getOrderNum())
            .andHotelIdEqualTo(record.getHotelId());
            List<MenuChannel> menuList = mapper.selectByExample(example);
            if(null != menuList && !menuList.isEmpty()) {
                MenuChannel baseChannel = mapper.selectByPrimaryKey(record.getId());
                if(!(null == menuList.get(0).getOrderNum())) {
                    if(!(baseChannel.getOrderNum() == menuList.get(0).getOrderNum())){
                        return -2;
                    }
                }
            }
        }
		return mapper.updateByPrimaryKeySelective(record);
	}

    @Override
    public Map<Pages, List<MenuChannel>> selectByPages(MenuChannelExample example,
            Pages page) {
        Map<Pages,List<MenuChannel>> map = new HashMap<Pages, List<MenuChannel>>();
        if(null == example)
            example = new MenuChannelExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<MenuChannel> menuChanneList = mapper.selectByExample(example);
        if(null == menuChanneList)
            menuChanneList = new ArrayList<MenuChannel>();
        PageInfo<MenuChannel> pageInfo =  new PageInfo<MenuChannel>(menuChanneList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, menuChanneList);
        return map;
    }
    
    @Override
    public Map<Pages, List<MenuChannel>> queryByParentIdList(Long parentId,Long hotelId,
            Pages page) {
        Map<Pages,List<MenuChannel>> map = new HashMap<Pages, List<MenuChannel>>();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<MenuChannel> menuChanneList = mapper.selectByParentIdList(parentId, hotelId);
        if(null == menuChanneList)
            menuChanneList = new ArrayList<MenuChannel>();
        PageInfo<MenuChannel> pageInfo =  new PageInfo<MenuChannel>(menuChanneList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, menuChanneList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
//        return mapper.deleteOnBatch(idList);
        return 0;
    }

    @Override
    public List<MenuChannel> selectByExample(MenuChannelExample example) {
       if(null == example) {
           return null;
       }
       return mapper.selectByExample(example);
    }
    
    @Override
    public JSONArray publish(Long hotelId) {
        JSONArray array = new JSONArray();
        if(null == hotelId) {
            return array;
        }
        
        MenuChannelExample channelExample = new MenuChannelExample();
        channelExample.createCriteria().andHotelIdEqualTo(hotelId)
        .andParentIdEqualTo(0L);
        List<MenuChannel> topChannelList = mapper.selectByExample(channelExample);
        if(null == topChannelList || topChannelList.size()<1) {
            return array;
        }
        dtreeSaveMassage(array, topChannelList);
        return array;
    }
    /**
     * 递归查询保存电视频道
     * @param topArray
     * @param topChannelList
     */
    public void dtreeSaveMassage(JSONArray topArray,List<MenuChannel> topChannelList){
        JSONObject menuChannelObj = null;
        for(MenuChannel menuChannel:topChannelList){
            menuChannelObj = new JSONObject();
            if(null == menuChannel) {
                continue;
            }
            saveChannel(menuChannelObj, menuChannel);
            List<MenuPages> pagesList = pagesMapper.selectByMenuId(menuChannel.getId());
            JSONObject pagesObj = new JSONObject();
            if(null != pagesList && pagesList.size() >0) {
                savePages(pagesList.get(0), pagesObj);
            }
            JSONArray childArray = new JSONArray();
            menuChannelObj.put("pages", pagesObj);
            menuChannelObj.put("childList", childArray);
            topArray.add(menuChannelObj);
            List<MenuChannel> childList = mapper.selectByParentId(menuChannel.getId());
            if(null != childList && childList.size() > 0) {
                dtreeSaveMassage(childArray, childList);
            }
        }
    }
    
    public void saveChannel(JSONObject pObj,MenuChannel pChannel){
        pObj.put("id",pChannel.getId());
        pObj.put("backImg", pChannel.getBackImg());
        pObj.put("menuImg", pChannel.getMenuImg());
        pObj.put("menuType", MenuType.enValuesOf(pChannel.getMenuType()).toIntVal());
        pObj.put("nameCn", pChannel.getNameCn());
        pObj.put("nameEn", pChannel.getNameEn());
        pObj.put("orderNum", pChannel.getOrderNum());
        pObj.put("serviceType", getSubMenuVal(pChannel.getServiceType()));
        pObj.put("subMenuType", pChannel.getSubMenuType());
        pObj.put("hotelId", pChannel.getHotelId());
        pObj.put("parentId", pChannel.getParentId());
        pObj.put("propertyType", pChannel.getPropertyYpe()); //属性类型：食品（0），商品（1）
    }
    
    public void savePages(MenuPages pages,JSONObject pagesObj){
        pagesObj.put("backImg",pages.getBackImg());
        pagesObj.put("contentCn",pages.getContentCn());
        pagesObj.put("contentEn",pages.getContentEn());
        pagesObj.put("img",pages.getImg());
        pagesObj.put("imgPosition",pages.getImgPosition());
        pagesObj.put("imgWidth",pages.getImgWidth());
        pagesObj.put("titleCn",pages.getTitleCn());
        pagesObj.put("titleEn",pages.getTitleEn());
    }
    
    
    private int getSubMenuVal(String serviceType) {
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
        default:
            return SubMenuType.SERVICE.toIntVal();
        }
    }

    @Override
    public int deleteAllId(Long id) {
        int res = mapper.deleteByPrimaryKey(id);
        if(res >0 ) {
            pagesMapper.deleteByChannelId(id);
        }else{
            return -1;
        }
        return res;
    }
}
