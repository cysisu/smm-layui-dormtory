package cn.wmyskxz.service;

import cn.wmyskxz.entity.RoomInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomInfoService {
    List<RoomInfo> getRoomInfos();
    int deleteByRoomNumber(String roomNumber);
    List<RoomInfo> searchRoomInfos(String roomNumber,int price,String type,String status);
    int insertRoomInfo(RoomInfo roomInfo);
    int getPriceByRoomNumber(String roomNumber);
}
