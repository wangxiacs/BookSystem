package zhongfucheng.web.client;

import zhongfucheng.domain.Cart;
import zhongfucheng.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ozc on 2017/4/16.
 */
@WebServlet(name = "listCart",urlPatterns = "/listCart")
public class listCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //先判断该用户是否登陆了
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("message", "您还没有登陆呢！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }

        //如果登陆了.....
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //把该用户的购物车给JSP页面显示
        request.getSession().setAttribute("cart", cart);
        request.getRequestDispatcher("/client/listCart.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
