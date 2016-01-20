package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpRoomTvBusiness;
import cn.pl.hmp.server.dao.entity.HmpRoomTv;
import cn.pl.hmp.server.dao.entity.HmpRoomTvExample;
import cn.pl.hmp.server.dao.mapper.HmpRoomTvMapper;
import cn.pl.hmp.server.utils.PageConverter;

@Service
public class HmpRoomTvBusinessImpl extends BoostBusinessImpl implements IHmpRoomTvBusiness {
    @Autowired
    private HmpRoomTvMapper mapper;

    @Override
    public int deleteByHmpRoomTvId(Long id) {
        if (id == null)
            return 0;
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(HmpRoomTv record) {
        if (record.getHotelId() == null) {
            return 0;
        }
        mapper.insert(record);
        return record.getId();
    }

    @Override
    public List<HmpRoomTv> selectAll() {
        return mapper.selectByExample(new HmpRoomTvExample());
    }

    @Override
    public Map<Pages, List<HmpRoomTv>> selectByPages(HmpRoomTvExample example, Pages page) {
        Map<Pages, List<HmpRoomTv>> map = new HashMap<Pages, List<HmpRoomTv>>();
        if (null == example)
            example = new HmpRoomTvExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<HmpRoomTv> tvList = mapper.selectByExample(example);
        if (null == tvList)
            tvList = new ArrayList<HmpRoomTv>();
        PageInfo<HmpRoomTv> pageInfo = new PageInfo<HmpRoomTv>(tvList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, tvList);

        return map;
    }

    @Override
    public int update(HmpRoomTv record) {
        if (record == null || record.getId() == null || record.getHotelId() == null)
            return 0;
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HmpRoomTv> selectByExample(HmpRoomTvExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public HmpRoomTv selectByHotelId(Long hotelId) {
        List<HmpRoomTv> roomTvList = mapper.selectByHotelId(hotelId);
        HmpRoomTv roomTv = null;
        if (null != roomTvList && !roomTvList.isEmpty()) {
            roomTv = roomTvList.get(0);
        } else {
            roomTv = new HmpRoomTv();
        }
        return roomTv;
    }

    @Override
    public JSONObject publish(Long hotelId) {
        HmpRoomTv roomTv = this.selectByHotelId(hotelId);
        JSONObject json = new JSONObject();
        if (null == roomTv.getId() || roomTv.getId() < 1) {
            return json;
        }
        json.put("id", roomTv.getId());
        json.put("backMusic", roomTv.getBackMusic());
        json.put("helpImg", roomTv.getHelpImg());
        json.put("homeImg", roomTv.getHomeImg());
        json.put("logoImg", roomTv.getLogoImg());
        json.put("screenImg", roomTv.getScreenImg());
        json.put("solgan", roomTv.getSolgan());
        json.put("tvCode", roomTv.getTvCode());
        json.put("tvModel", roomTv.getTvModel());
        json.put("tvNum", roomTv.getTvNum());
        json.put("roomId", roomTv.getRoomId());
        json.put("hotelId", roomTv.getHotelId());
        json.put("welcomeCt", roomTv.getWelcomeCt());
        json.put("welcomeCtEn", roomTv.getWelcomeCtEn());
        json.put("welcomeImg", roomTv.getWelcomeImg());
        json.put("solganCn", roomTv.getSolganCn());
        json.put("signalSource", roomTv.getSignalSource());
        return json;
    }
}