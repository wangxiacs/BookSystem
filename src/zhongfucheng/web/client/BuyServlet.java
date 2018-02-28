package zhongfucheng.web.client;

import zhongfucheng.domain.Book;
import zhongfucheng.domain.Cart;
import zhongfucheng.domain.User;
import zhongfucheng.service.BussinessServiceDao;
import zhongfucheng.service.impl.BussinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ozc on 2017/4/16.
 */
@WebServlet(name = "BuyServlet",urlPatterns = "/BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BussinessServiceDao service = new BussinessServiceImpl();

        //先检查该用户是否登陆了。
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("message", "您还没登陆，请登陆了再来购买");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return ;
        }

        //如果登陆了...

        //得到该用户的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        //得到用户想买的书籍
        String book_id = request.getParameter("book_id");
        Book book = service.findBook(book_id);

        //把书籍添加到购物车中
        service.buyBook(cart, book);
        request.setAttribute("message", "该商品已添加到购物车中");
        request.getRequestDispatcher("/message.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
