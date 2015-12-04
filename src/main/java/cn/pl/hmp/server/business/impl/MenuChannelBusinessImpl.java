package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
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
		return mapper.insert(record);
	}

	@Override
	public MenuChannel selectByMenuChannelId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MenuChannel> selectAll() {
		return mapper.selectByExample(new MenuChannelExample());
	}

	@Override
	public int update(MenuChannel record) {
		return mapper.updateByPrimaryKey(record);
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
        JSONObject pObj = null;
        JSONObject childObj = null;
        for(MenuChannel channel:topChannelList ) {
            if(null == channel) {
                continue;
            }
            pObj = new JSONObject();
            saveChannel(pObj, channel);
            List<MenuChannel> childList = mapper.selectByParentId(channel.getId());
            JSONArray childArray = new JSONArray();
            if(null != childList && childList.size() > 0) {
                for(MenuChannel childChannel:childList) {
                    childObj = new JSONObject();
                    if(null == childChannel) {
                        continue;
                    }
                    saveChannel(childObj, childChannel);
                    List<MenuPages> pagesList = pagesMapper.selectByMenuId(childChannel.getId());
                    JSONObject pagesObj = new JSONObject();
                    if(null != pagesList && pagesList.size() >0) {
                        savePages(pagesList.get(0), pagesObj);
                    }
                    childObj.put("pages", pagesObj);
                    childArray.add(childObj);
                }
            }
            pObj.put("childList", childArray);
            array.add(pObj);
        }
        return array;
    }
    
    public void saveChannel(JSONObject pObj,MenuChannel pChannel){
        pObj.put("id",pChannel.getId());
        pObj.put("backImg", pChannel.getBackImg());
        pObj.put("menuImg", pChannel.getMenuImg());
        pObj.put("menuType", pChannel.getMenuType());
        pObj.put("nameCn", pChannel.getNameCn());
        pObj.put("nameEn", pChannel.getNameEn());
        pObj.put("orderNum", pChannel.getOrderNum());
        pObj.put("serviceType", pChannel.getServiceType());
        pObj.put("subMenuType", pChannel.getSubMenuType());
        pObj.put("hotelId", pChannel.getHotelId());
        pObj.put("parentId", pChannel.getParentId());
        pObj.put("propertyYpe", pChannel.getPropertyYpe());
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

}
