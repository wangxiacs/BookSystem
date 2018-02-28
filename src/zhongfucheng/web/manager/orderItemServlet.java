package zhongfucheng.web.manager;

import zhongfucheng.domain.Order;
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
@WebServlet(name = "orderItemServlet",urlPatterns = "/orderItemServlet")
public class orderItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BussinessServiceDao service = new BussinessServiceImpl();

        //得到用户想要查看详细信息的表单
        String order_id = request.getParameter("order_id");

        Order order = service.findOrder(order_id);

        //将该order对象给相对应的JSP显示
        request.setAttribute("order", order);
        request.getRequestDispatcher("/background/listDetail.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
