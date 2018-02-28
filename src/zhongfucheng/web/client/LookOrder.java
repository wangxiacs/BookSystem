package zhongfucheng.web.client;

import zhongfucheng.domain.Order;
import zhongfucheng.domain.User;
import zhongfucheng.service.BussinessServiceDao;
import zhongfucheng.service.impl.BussinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ozc on 2017/4/17.
 */
@WebServlet(name = "LookOrder",urlPatterns = "/LookOrder")
public class LookOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BussinessServiceDao service = new BussinessServiceImpl();

        //检查该用户是否登陆了
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("message", "您还没登陆，等您登陆了再来看把");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }

        //用户登陆了！
        List<Order> orders = service.findUserOrder(user.getId());
        System.out.println("这里是订单有多少个："+orders.size());

        //交给相对应的JSP 显示
        request.setAttribute("orders", orders);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/client/listOrder.jsp").forward(request, response);
        return ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
