package zhongfucheng.service.impl;

import zhongfucheng.dao.BookDao;
import zhongfucheng.dao.CategoryDao;
import zhongfucheng.dao.OrderDao;
import zhongfucheng.dao.UserDao;
import zhongfucheng.domain.*;
import zhongfucheng.service.BussinessServiceDao;
import zhongfucheng.utils.DaoFactory;
import zhongfucheng.utils.WebUtils;
import zhongfucheng.utils.permission;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ozc on 2017/4/12.
 */
public class BussinessServiceImpl implements BussinessServiceDao {

    private CategoryDao categoryDao = DaoFactory.getInstance().createDao("zhongfucheng.dao.impl.CategoryDAOImpl", CategoryDao.class);

    private BookDao bookDao = DaoFactory.getInstance().createDao("zhongfucheng.dao.impl.BookDaoImpl", BookDao.class);

    private UserDao userDao = DaoFactory.getInstance().createDao("zhongfucheng.dao.impl.UserDaoImpl", UserDao.class);

    private OrderDao orderDao = DaoFactory.getInstance().createDao("zhongfucheng.dao.impl.OrderDaoImpl", OrderDao.class);


    @Override
    @permission("添加分类")
    /*添加分类*/
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }


    /*查找分类*/
    @Override
    public void findCategory(String id) {
        categoryDao.findCategory(id);
    }

    @Override
    @permission("查找分类")
    /*查看分类*/
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    /*添加图书*/
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);

    }

    /*查找图书*/
    @Override
    public Book findBook(String id) {
        return bookDao.findBook(id);
    }

    /*获取图书的分页数据*/
    @Override
    public Page getPageData(String currentPageCount) {

        Page page=null;

        if (currentPageCount == null) {
            page = new Page(1, bookDao.getTotalRecord());
        } else {
            page = new Page(Integer.valueOf(currentPageCount), bookDao.getTotalRecord());
        }

        List<Book> books = bookDao.getPageData(page.getStartIndex(), page.getLinesize());
        page.setList(books);


        return page;

    }

    /*获取图书分类后的分页数据*/
    @Override
    public Page getPageData(String currentPageCount, String category_id) {

        Page page=null;
        if (currentPageCount == null) {
            page = new Page(1, bookDao.getCategoryTotalRecord(category_id));
        } else {
            page = new Page(Integer.valueOf(currentPageCount), bookDao.getCategoryTotalRecord(category_id));
        }

        List<Book> books = bookDao.getPageData(page.getStartIndex(), page.getLinesize(), category_id);
        page.setList(books);
        return page;
    }

    @Override
    public void registerUser(User user) {
        userDao.register(user);
    }

    @Override
    public User loginUser(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public User findUser(String id) {
        return userDao.find(id);
    }

    @Override
    public void buyBook(Cart cart, Book book) {
        cart.addBook2Cart(book);

    }

    @Override
    public void createOrder(Cart cart, User user) {

        //订单的基本信息
        String order_id = WebUtils.makeId();
        Order order = new Order();
        order.setId(order_id);
        order.setPrice(cart.getPrice());
        order.setOrdertime(new Date());
        order.setState(false);
        order.setUser_id(user.getId());


        //订单项的基本信息
        //得到每个购物项，购物项就作为订单项
        for (Map.Entry<String, CartItem> me : cart.getMap().entrySet()) {

            OrderItem orderItem = new OrderItem();
            CartItem cartItem = me.getValue();

            orderItem.setId(WebUtils.makeId());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setBook_id(cartItem.getBook().getId());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder_id(order_id);
            order.getItems().add(orderItem);
        }

        System.out.println(cart.getMap().size());
        orderDao.addOrder(order);

    }

    @Override
    public Order findOrder(String user_id) {

        return orderDao.findOrder(user_id);
    }

    @Override
    public List<Order> getAllOrder(boolean state) {
        return orderDao.getAllOrder(state);
    }

    @Override
    public void sendOutOrder(String id) {

        orderDao.updateState(id);
    }

    @Override
    public List<Order> findUserOrder(String user_id) {
        return orderDao.findUserOrder(user_id);
    }

    @Override
    public List<Privilege> findUserPrivilege(String user_id) {
        return userDao.findUserPrivilege(user_id);
    }

}
