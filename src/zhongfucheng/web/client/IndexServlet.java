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
 * Created by ozc on 2017/4/13.
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到所有的分类数据，给body页面
        BussinessServiceDao service = new BussinessServiceImpl();
        List<Category> categories = service.getAllCategory();
        request.setAttribute("categories", categories);
        String currentPageCount = request.getParameter("currentPageCount");

        //得到所有分类的图书，给body页面
        Page page = service.getPageData(currentPageCount);
        request.setAttribute("page", page);

        request.getRequestDispatcher("/client/body.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
