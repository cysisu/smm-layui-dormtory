package cn.wmyskxz.controller;

import cn.wmyskxz.entity.Order;
import cn.wmyskxz.entity.User;
import cn.wmyskxz.service.AdminService;
import cn.wmyskxz.service.OrderService;
import cn.wmyskxz.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomInfoService roomInfoService;

    @RequestMapping(value="/getOrders", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOrders(){
        List<Order> orderList = orderService.getOrderList();
        System.out.println("返回数据个数:"+orderList.size());
        System.out.println(orderList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 4);
        map.put("data", orderList);
        return map;
    }

    @RequestMapping(value="/setOrder", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> add(@RequestBody Order order) {
        System.out.println(order);
        String roomNumber=order.getRoomNumber();
        order.setPrice(roomInfoService.getPriceByRoomNumber(roomNumber));
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        if(order.getStatus().equals("1")){
            order.setStatus("booked");
        }
        else{
            order.setStatus("check in");
        }

        if(order.getStatus().equals("check in")){
            order.setPredictTime(date);
            order.setInTime(date);
        }
        else{
            Date d1=order.getPredictTime();
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(d1);
            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),12,0,0);
            d1=calendar.getTime();
            order.setPredictTime(d1);
        }
        int result = orderService.insert(order);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteById(@PathVariable("orderId") int orderId) {
        System.out.println("是否请求删除过");
        int result = orderService.deleteByOrderId(orderId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/findSpecificOrder")
    @ResponseBody
    public Map<String, Object> findSpecificOrder(@RequestParam("identityId") String identityId,@RequestParam("roomNumber") String roomNumber ,int page, int limit) {
        System.out.println("查找过！"+"identityId: "+identityId+"  roomNumber:"+roomNumber);

        List<Order> orderList = orderService.findSpecificOrders(identityId,roomNumber);

        int count = orderList.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", count);
        map.put("data", orderList);
        System.out.println(map);
        return map;
    }

    @RequestMapping(value = "/updateOrder" )
    @ResponseBody
    public Map<String, Object> updateOrder( int orderIdUpdate, String roomNumberUpdate, String statusUpdate, String labelUpdate) {
        Order order=orderService.getOrderById(orderIdUpdate);
        order.setRoomNumber(roomNumberUpdate);
        order.setStatus(statusUpdate);
        order.setLabel(labelUpdate);
        System.out.println("更新过："+order);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        if(order.getStatus().equals("1")){
            order.setStatus("booked");
        }
        else if(order.getStatus().equals("2")){
            order.setStatus("check in");
            order.setInTime(date);
        }
        else if(order.getStatus().equals("3")){
            order.setStatus("leave");
            System.out.println("离开时间："+date);
            order.setOutTime(date);
        }
        int result = orderService.updateOrder(order);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }




}
