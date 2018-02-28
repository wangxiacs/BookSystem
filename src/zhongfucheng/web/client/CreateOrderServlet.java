package zhongfucheng.web.client;

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
 * Created by ozc on 2017/4/17.
 */
@WebServlet(name = "CreateOrderServlet",urlPatterns = "/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BussinessServiceDao service = new BussinessServiceImpl();

        //检查该用户的购物车是否有商品
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            request.setAttribute("message", "您购物车没有商品，无法生成订单");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }

        //如果有商品，得到当前用户
        User user = (User) request.getSession().getAttribute("user");
        service.createOrder(cart, user);
        request.setAttribute("message", "订单已经生成了，准备好钱来收货把");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
        return;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
