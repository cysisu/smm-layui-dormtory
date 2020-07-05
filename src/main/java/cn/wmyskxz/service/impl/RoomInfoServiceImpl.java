package cn.wmyskxz.service.impl;

import cn.wmyskxz.dao.RoomInfoDao;
import cn.wmyskxz.entity.RoomInfo;
import cn.wmyskxz.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomInfoServiceImpl implements RoomInfoService {

    @Autowired
    private RoomInfoDao roomInfoDao;
    public List<RoomInfo> getRoomInfos(){
        return roomInfoDao.getRoomInfos();
    }

    public int deleteByRoomNumber(String roomNumber){
        return roomInfoDao.deleteByRoomNumber(roomNumber);
    }

    public List<RoomInfo> searchRoomInfos(String roomNumber, int price, String type, String status){
        return roomInfoDao.searchRoomInfos(roomNumber,type,price,status);
    }
    public int insertRoomInfo(RoomInfo roomInfo){
        return roomInfoDao.insertRoomInfo(roomInfo);
    }
    public int getPriceByRoomNumber(String roomNumber){
        return roomInfoDao.getPriceByRoomNumber(roomNumber);
    }
}
