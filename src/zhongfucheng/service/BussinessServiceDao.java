package zhongfucheng.service;

import zhongfucheng.domain.*;
import zhongfucheng.utils.permission;

import java.util.List;

/**
 * Created by ozc on 2017/4/25.
 */
public interface BussinessServiceDao {


    @permission("添加分类")
    /*添加分类*/ void addCategory(Category category);

    /*查找分类*/
    void findCategory(String id);

    @permission("查找分类")
    /*查看分类*/ List<Category> getAllCategory();

    /*添加图书*/
    void addBook(Book book);

    /*查找图书*/
    Book findBook(String id);

    /*获取图书的分页数据*/
    Page getPageData(String currentPageCount);

    /*获取图书分类后的分页数据*/
    Page getPageData(String currentPageCount, String category_id);

    void registerUser(User user);

    User loginUser(String username, String password);

    User findUser(String id);

    void buyBook(Cart cart, Book book);

    void createOrder(Cart cart, User user);

    Order findOrder(String user_id);

    List<Order> getAllOrder(boolean state);

    void sendOutOrder(String id);

    List<Order> findUserOrder(String user_id);

    List<Privilege> findUserPrivilege(String user_id);
}
