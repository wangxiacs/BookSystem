package zhongfucheng.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ozc on 2017/4/17.
 */
public class Order {

    private String id;

    //下单的时间、日期、状态
    private Date ordertime;
    private double price;
    private boolean state;

    //一个用户可以有多个订单，把用户记住
    private String user_id;

    //一个订单中有多个订单项
    private Set<OrderItem> items = new HashSet<>();

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
