package cn.wmyskxz.service.impl;

import cn.wmyskxz.dao.OrderDao;
import cn.wmyskxz.entity.Order;
import cn.wmyskxz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    public int insert(Order order){
        return orderDao.insertOrder(order);
    }

    public int deleteByOrderId(int id){
        return orderDao.deleteByOrderId(id);
    }

    public List<Order> findSpecificOrders(String identityId, String roomNumber){
        List<Order> orderList=orderDao.findSpecificOrders(identityId,roomNumber);
        return orderList;
    }

    public int updateOrder(Order order){
        int count=orderDao.updateOrder(order);
        return count;
    }

    public Order getOrderById(int orderId){
        return orderDao.getOrderById(orderId);
    }
}
