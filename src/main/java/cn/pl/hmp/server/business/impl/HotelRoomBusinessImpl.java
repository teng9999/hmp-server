package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHotelRoomBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelRoomBusinessImpl extends BoostBusinessImpl implements IHotelRoomBusiness{

	@Autowired
	private HotelRoomMapper mapper;

	@Override
	public int deleteByHotelRoomId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(HotelRoom record) {
		return mapper.insert(record);
	}

	@Override
	public HotelRoom selectByHotelRoomId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HotelRoom> selectAll() {
		return mapper.selectByExample(new HotelRoomExample());
	}

	@Override
	public int update(HotelRoom record) {
		return mapper.updateByPrimaryKey(record);
	}

    @Override
    public Map<Pages, List<HotelRoom>> selectByPages(HotelRoomExample example,
            Pages page) {
        Map<Pages,List<HotelRoom>> map = new HashMap<Pages, List<HotelRoom>>();
        if(null == example)
            example = new HotelRoomExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        List<HotelRoom> hotelRoomList = mapper.selectListAddUniqueNum(example);
        if(null == hotelRoomList)
            hotelRoomList = new ArrayList<HotelRoom>();
        PageInfo<HotelRoom> pageInfo =  new PageInfo<HotelRoom>(hotelRoomList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, hotelRoomList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
       return 0;
        // return mapper.deleteOnBatch(idList);
    }

    @Override
    public int saveOnBatch(HotelRoom record, String roomNums) {
        if(null == record||null == roomNums||"".equals(roomNums.trim()))
            return 0;
        List<HotelRoom> roomList = new ArrayList<HotelRoom>();
        HotelRoom tempRoom = null;
        String[] roomNumArray = roomNums.split("-");
        if(null == roomNumArray || roomNums.length()<2)
            return 0;
        for(int i = Integer.parseInt(roomNumArray[0]);i<=Integer.parseInt(roomNumArray[1]);i++){
            tempRoom = record.clone(record);
            tempRoom.setRoomNum(i+"");
            roomList.add(tempRoom);
        }
        return mapper.insertBatch(roomList);
    }

}
