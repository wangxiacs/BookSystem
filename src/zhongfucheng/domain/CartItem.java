package zhongfucheng.domain;

/**
 * Created by ozc on 2017/4/16.
 */
public class CartItem {

    private Book book;
    private double price;
    private int quantity;

    public double getPrice() {
        return this.book.getPrice() * this.quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
