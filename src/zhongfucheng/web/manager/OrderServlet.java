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
import java.util.List;

/**
 * Created by ozc on 2017/4/17.
 */
@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        BussinessServiceDao service = new BussinessServiceImpl();
        String state = request.getParameter("state");


        if (state.equals("true")) {
            List<Order> list = service.getAllOrder(true);
            request.setAttribute("list",list);

        } else if (state.equals("false")) {
            List<Order> list = service.getAllOrder(false);
            request.setAttribute("list", list);
        }


        request.getRequestDispatcher("/background/listOrder.jsp").forward(request, response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
