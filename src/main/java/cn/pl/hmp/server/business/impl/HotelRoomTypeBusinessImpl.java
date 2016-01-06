package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHotelRoomTypeBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.entity.HotelRoomType;
import cn.pl.hmp.server.dao.entity.HotelRoomTypeExample;
import cn.pl.hmp.server.dao.mapper.HotelInfoMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomTypeMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class HotelRoomTypeBusinessImpl extends BoostBusinessImpl implements IHotelRoomTypeBusiness{
    
    @Autowired
    private HotelRoomTypeMapper roomTypeMapper;
    @Autowired
    private HotelInfoMapper hotelMapper;
    @Override
    public int delete(Long id) {
        if(null == id) {
            return -1;
        }
        return roomTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(HotelRoomType record) {
        if(null == record) {
            return -1;
        }
        return roomTypeMapper.insertSelective(record);
    }

    @Override
    public HotelRoomType selectById(Long id) {
        if(null == id) {
            return null;
        }
        return roomTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HotelRoomType> selectByHotel(Long hotelId) {
        if(null == hotelId) {
            return null;
        }
        HotelRoomTypeExample example = new HotelRoomTypeExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        return roomTypeMapper.selectByExample(example);
    }

    @Override
    public Map<Pages, List<HotelRoomType>> selectByPages(Long hotelId,
            Pages page) {
        if(null == hotelId) {
            return null;
        }
        if(page == null ) {
            page = new Pages(); 
        }
        Map<Pages, List<HotelRoomType>> map = new HashMap<Pages, List<HotelRoomType>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        HotelRoomTypeExample example = new HotelRoomTypeExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        List<HotelRoomType> hotelRoomList = roomTypeMapper.selectByExample(example);
        if (null == hotelRoomList)
            hotelRoomList = new ArrayList<HotelRoomType>();
        PageInfo<HotelRoomType> pageInfo = new PageInfo<HotelRoomType>(hotelRoomList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelRoomList);
        return map;
    }

    @Override
    public int update(HotelRoomType record) {
        if(null == record) {
            return -1;
        }
        return roomTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        int res = 0;
        if(null == idList) {
            return res;
        }
        for(Long typeId : idList) {
            if(this.delete(typeId) > 0) {
                res++;
            };
       }
        return res;
    }

    @Override
    public int updateOnBatch(List<HotelRoomType> typeList) {
        int res = 0;
        if(null == typeList) {
            return res;
        }
        for(HotelRoomType roomType : typeList) {
             if(this.update(roomType) > 0) {
                 res++;
             };
        }
        return res;
    }

    @Override
    public boolean checkName(HotelRoomType roomType) {
        HotelRoomTypeExample example = new HotelRoomTypeExample();
        example.createCriteria().andHotelIdEqualTo(roomType.getHotelId())
        .andNameEqualTo(roomType.getName());
        List<HotelRoomType> roomTypeList = roomTypeMapper.selectByExample(example);
        if(null != roomTypeList && !roomTypeList.isEmpty()) {
            if(roomType.getId() != null && roomType.getId().longValue() == roomTypeList.get(0).getId().longValue()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int addDefaultTypes(List<String> typeList) {
        List<HotelInfo> hotelList = hotelMapper.selectByExample(new HotelInfoExample());
        HotelRoomType roomType = new HotelRoomType();
        roomType.setCreateTime(new Date());
        int res = 0;
        if(null != hotelList && !hotelList.isEmpty()) {
            for(HotelInfo hotel: hotelList) {
                if(null != typeList && !typeList.isEmpty()) {
                    for(String typeName: typeList) {
                        roomType.setHotelId(hotel.getId());
                        roomType.setId(null);
                        roomType.setName(typeName);
                        if(checkName(roomType)) {
                            continue;
                        }
                        int result = roomTypeMapper.insertSelective(roomType);
                        if(result > 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    @Override
    public List<String> queryAllDistinct(long hotelId) {
        return roomTypeMapper.selectDistinctName(hotelId);
    }

}
