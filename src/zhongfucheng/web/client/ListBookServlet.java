package zhongfucheng.web.client;

import zhongfucheng.domain.Category;
import zhongfucheng.domain.Page;
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
 * Created by ozc on 2017/4/14.
 */
@WebServlet(name = "ListBookServlet",urlPatterns = "/ListBookServlet")
public class ListBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BussinessServiceDao service = new BussinessServiceImpl();
        String currentPageCount = request.getParameter("currentPageCount");
        String category_id = request.getParameter("category_id");

        Page page = service.getPageData(currentPageCount, category_id);
        List<Category>  categories = service.getAllCategory();

        request.setAttribute("page", page);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/client/body.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
