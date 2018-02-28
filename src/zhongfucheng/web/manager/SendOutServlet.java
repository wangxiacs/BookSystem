package zhongfucheng.web.manager;

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
@WebServlet(name = "SendOutServlet",urlPatterns = "/SendOutServlet")
public class SendOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BussinessServiceDao service = new BussinessServiceImpl();
        String id = request.getParameter("id");

        service.sendOutOrder(id);
        request.setAttribute("message", "已发货！");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
