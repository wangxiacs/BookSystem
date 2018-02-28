package zhongfucheng.dao;

import zhongfucheng.domain.Order;

import java.util.List;

/**
 * Created by ozc on 2017/4/17.
 */
public interface OrderDao {
    void addOrder(Order order);

    Order findOrder(String user_id);

    List<Order> getAllOrder(boolean state);

    void updateState(String user_id);

    List<Order> findUserOrder(String user_id);
}
