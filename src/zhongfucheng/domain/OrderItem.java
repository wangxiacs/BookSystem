package zhongfucheng.domain;

/**
 * Created by ozc on 2017/4/17.
 */
public class OrderItem {

    private String id;

    //一个订单可以对应多个订单，记住订单
    private String order_id;

    //一本书对应多个订单项，订单项一定是由书组成，记住书
    private String book_id;

    private double price;
    private int quantity;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
