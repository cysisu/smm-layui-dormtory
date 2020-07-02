package cn.wmyskxz.service;

import cn.wmyskxz.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();

    int insert(Order order);

    int deleteByOrderId(int id);

    List<Order> findSpecificOrders(String identityId,String roomNumber);

    int updateOrder(Order order);

    Order getOrderById(int orderId);

}
