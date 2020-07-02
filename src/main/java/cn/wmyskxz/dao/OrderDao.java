package cn.wmyskxz.dao;

import cn.wmyskxz.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    List<Order> getOrderList();

    int insertOrder(Order order);

    int deleteByOrderId(int id);

    List<Order> findSpecificOrders(@Param("identityId")String identityId,@Param("roomNumber") String roomNumber);

    int updateOrder(Order order);

    Order getOrderById(int orderId);
}
