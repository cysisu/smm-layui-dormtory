package cn.wmyskxz.dao;

import cn.wmyskxz.entity.Customer;
import cn.wmyskxz.entity.RoomInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomInfoDao {
    List<RoomInfo> getRoomInfos();
    int deleteByRoomNumber(@Param("roomNumber")String roomNumber);
    List<RoomInfo> searchRoomInfos(@Param("roomNumber")String roomNumber,@Param("type")String type,@Param("price")int price,@Param("status")String status);
    int insertRoomInfo(RoomInfo roomInfo);
    int getPriceByRoomNumber(@Param("roomNumber")String roomNumber);
}
