package cn.pl.hmp.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.hmp.commons.enums.roomRcu.UserType;
import cn.pl.hmp.server.business.iface.IClearLitterBusiness;
import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.AirModeExample;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacks;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacksExample;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HmpMGHotelExample;
import cn.pl.hmp.server.dao.entity.HmpRoomTv;
import cn.pl.hmp.server.dao.entity.HmpRoomTvExample;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.dao.entity.HotelRCUCfgExample;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;
import cn.pl.hmp.server.dao.entity.PublishPkgs;
import cn.pl.hmp.server.dao.entity.PublishPkgsExample;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;
import cn.pl.hmp.server.dao.entity.UserHotel;
import cn.pl.hmp.server.dao.entity.UserHotelExample;
import cn.pl.hmp.server.dao.mapper.AirModeMapper;
import cn.pl.hmp.server.dao.mapper.HmpHotelToolPacksMapper;
import cn.pl.hmp.server.dao.mapper.HmpMGHotelMapper;
import cn.pl.hmp.server.dao.mapper.HmpRoomTvMapper;
import cn.pl.hmp.server.dao.mapper.HotelInfoMapper;
import cn.pl.hmp.server.dao.mapper.HotelRCUCfgMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
import cn.pl.hmp.server.dao.mapper.MenuChannelMapper;
import cn.pl.hmp.server.dao.mapper.MenuPagesMapper;
import cn.pl.hmp.server.dao.mapper.PublishPkgsMapper;
import cn.pl.hmp.server.dao.mapper.RoomRCUCfgMapper;
import cn.pl.hmp.server.dao.mapper.UserHotelMapper;
import cn.pl.hmp.server.dao.mapper.UserMapper;

@Service
public class ClearLitterBusinessImpl extends BoostBusinessImpl implements IClearLitterBusiness {

    @Autowired
    private HotelInfoMapper hotelMapper;
    @Autowired
    private HotelRCUCfgMapper hotelRcuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserHotelMapper userHotelMapper;
    @Autowired
    private HotelRoomMapper roomMapper;
    @Autowired
    private RoomRCUCfgMapper roomRcuMapper;
    @Autowired
    private AirModeMapper airModeMapper;
    @Autowired
    private HmpHotelToolPacksMapper hotelToolPacksMapper;
    @Autowired
    private MenuChannelMapper menuChannelMapper;
    @Autowired
    private MenuPagesMapper menuPagesMapper;
    @Autowired
    private HmpMGHotelMapper mgHotelMapper;
    @Autowired
    private PublishPkgsMapper publishPkgsMapper;
    @Autowired
    private HmpRoomTvMapper roomTvMapper;

    @Override
    public long deleteAllDataExceptHotelId(Long hotelId) throws Exception {
        System.err.println(
                "--------------------------------------------------------------------------------------------------------------------------------");
        deleteAirModel(hotelId);
        deleteHotel(hotelId);
        deleteHotelRcu(hotelId);
        deleteHotelRoom(hotelId);
        deleteMenuChannel(hotelId);
        deleteMGHotel(hotelId);
        deletePublishPkgs(hotelId);
        deleteRoomRcu(hotelId);
        deleteRoomTv(hotelId);
        deleteToolPacks(hotelId);
        deleteUser(hotelId);
        deleteUserHotel(hotelId);
        return 1;
    }

    /**
     * 删除酒店信息
     * 
     * @param hotelId
     */
    public void deleteHotel(Long hotelId) {
        HotelInfoExample example = new HotelInfoExample();
        example.createCriteria().andIdNotEqualTo(hotelId);
        List<HotelInfo> list = hotelMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (HotelInfo entity : list) {
                if (null == entity) {
                    continue;
                }
                hotelMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    public void deleteUser(Long hotelId) {
        UserHotelExample userHotelExample = new UserHotelExample();
        userHotelExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<UserHotel> userHotelList = userHotelMapper.selectByExample(userHotelExample);
        if (null != userHotelList && !userHotelList.isEmpty()) {
            UserHotel userHotel = userHotelList.get(0);
            if (null == userHotel) {
                return;
            }
            Long userId = userHotel.getUserId();
            if (userId != null) {
                UserExample userExample = new UserExample();
                userExample.createCriteria().andIdNotEqualTo(userId).andUserTypeNotEqualTo(UserType.ADMIN.name());
                List<User> userList = userMapper.selectByExample(userExample);
                if (null != userList && !userList.isEmpty()) {
                    for (User user : userList) {
                        if (null == user) {
                            continue;
                        }
                        userMapper.deleteByPrimaryKey(user.getId());
                    }
                }
            }
        }
    }

    public void deleteUserHotel(Long hotelId) {
        UserHotelExample userHotelExample = new UserHotelExample();
        userHotelExample.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<UserHotel> userHotelList = userHotelMapper.selectByExample(userHotelExample);
        if (null != userHotelList && !userHotelList.isEmpty()) {
            for (UserHotel userHotel : userHotelList) {
                if (null == userHotel) {
                    continue;
                }
                User user = userMapper.selectByPrimaryKey(userHotel.getUserId());

                if (user != null && !UserType.ADMIN.name().equals(user.getUserType())) {
                    userMapper.deleteByPrimaryKey(userHotel.getUserId());
                }
                userHotelMapper.deleteByPrimaryKey(userHotel.getId());
            }
        }
    }

    public void deleteAirModel(Long hotelId) {
        AirModeExample example = new AirModeExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<AirMode> list = airModeMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (AirMode entity : list) {
                if (null == entity) {
                    continue;
                }
                airModeMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    public void deleteHotelRcu(Long hotelId) {
        HotelRCUCfgExample example = new HotelRCUCfgExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<HotelRCUCfg> list = hotelRcuMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (HotelRCUCfg entity : list) {
                if (null == entity) {
                    continue;
                }
                hotelRcuMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    public void deleteHotelRoom(Long hotelId) {
        HotelRoomExample example = new HotelRoomExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<HotelRoom> list = roomMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (HotelRoom entity : list) {
                if (null == entity) {
                    continue;
                }
                roomMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    /**
     * 删除房间rcu配置
     * 
     * @param hotelId
     */
    public void deleteRoomRcu(Long hotelId) {
        RoomRCUCfgExample example = new RoomRCUCfgExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<RoomRCUCfg> list = roomRcuMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (RoomRCUCfg entity : list) {
                if (null == entity) {
                    continue;
                }
                roomRcuMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    /**
     * 删除酒店电影中间表
     * 
     * @param hotelId
     */
    public void deleteMGHotel(Long hotelId) {
        HmpMGHotelExample example = new HmpMGHotelExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<HmpMGHotel> list = mgHotelMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (HmpMGHotel entity : list) {
                if (null == entity) {
                    continue;
                }
                mgHotelMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    /**
     * 删除酒店发布包
     * 
     * @param hotelId
     */
    public void deletePublishPkgs(Long hotelId) {
        PublishPkgsExample example = new PublishPkgsExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<PublishPkgs> list = publishPkgsMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (PublishPkgs entity : list) {
                if (null == entity) {
                    continue;
                }
                publishPkgsMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    /**
     * 删除酒店房间电视
     * 
     * @param hotelId
     */
    public void deleteRoomTv(Long hotelId) {
        HmpRoomTvExample example = new HmpRoomTvExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<HmpRoomTv> list = roomTvMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (HmpRoomTv entity : list) {
                if (null == entity) {
                    continue;
                }
                roomTvMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    /**
     * 删除工具包
     * 
     * @param hotelId
     */
    public void deleteToolPacks(Long hotelId) {
        HmpHotelToolPacksExample example = new HmpHotelToolPacksExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<HmpHotelToolPacks> list = hotelToolPacksMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (HmpHotelToolPacks entity : list) {
                if (null == entity) {
                    continue;
                }
                hotelToolPacksMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

    /**
     * 删除电视菜单频道
     * 
     * @param hotelId
     */
    public void deleteMenuChannel(Long hotelId) {
        MenuChannelExample example = new MenuChannelExample();
        example.createCriteria().andHotelIdNotEqualTo(hotelId);
        List<MenuChannel> list = menuChannelMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (MenuChannel entity : list) {
                if (null == entity) {
                    continue;
                }
                menuPagesMapper.deleteByChannelId(entity.getId());
                menuChannelMapper.deleteByPrimaryKey(entity.getId());
            }
        }
    }

}
