package cn.wmyskxz.controller;


import cn.wmyskxz.entity.Customer;
import cn.wmyskxz.entity.RoomInfo;
import cn.wmyskxz.entity.User;
import cn.wmyskxz.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roomInfo")
public class roomInfoController {

    @Autowired
    private RoomInfoService roomInfoService;

    @RequestMapping(value="/getRoomInfos", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRoomInfos(){
        List<RoomInfo> roomInfoList = roomInfoService.getRoomInfos();
        System.out.println("返回数据个数:"+roomInfoList.size());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", roomInfoList.size());
        map.put("data", roomInfoList);
        return map;
    }

    @RequestMapping(value = "/{roomNumber}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        int result = roomInfoService.deleteByRoomNumber(roomNumber);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/findSpecificRoomInfo")
    @ResponseBody
    public Map<String, Object> findSpecificRoomInfo(@RequestParam("roomNumber") String roomNumber, @RequestParam("price") int price, @RequestParam("type") String type, @RequestParam("status") String status, int page, int limit) {
        if(status.equals("1")){
            status="booked";
        }else if(status.equals("2")){
            status="rented";
        }else if(status.equals("3")){
            status="vacant";
        }
        if(type.equals("1")){
            type="大床房";
        }else if(type.equals("2")){
            type="单人间";
        }else if(type.equals("3")){
            type="总统套房";
        }

        List<RoomInfo> roomInfoList=roomInfoService.searchRoomInfos(roomNumber,price,type,status);

        int count = roomInfoList.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", count);
        map.put("data", roomInfoList);
        System.out.println(map);
        return map;
    }

    @RequestMapping(value = "/insert")
    @ResponseBody
    public Map<String, Object> insertCustomer(@RequestBody RoomInfo roomInfo){

        if(roomInfo.getStatus().equals("1")){
            roomInfo.setStatus("booked");;
        }else if(roomInfo.getStatus().equals("2")){
            roomInfo.setStatus("rented");
        }else if(roomInfo.getStatus().equals("3")){
            roomInfo.setStatus("vacant");
        }
        if(roomInfo.getType().equals("1")){
            roomInfo.setType("大床房");
        }else if(roomInfo.getType().equals("2")){
            roomInfo.setType("单人间");
        }else if(roomInfo.getType().equals("3")){
            roomInfo.setType("总统套房");
        }

        int result= roomInfoService.insertRoomInfo(roomInfo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",result);
        return map;
    }

}
