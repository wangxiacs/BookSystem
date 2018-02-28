package zhongfucheng.web.manager;

import zhongfucheng.domain.Category;
import zhongfucheng.domain.User;
import zhongfucheng.service.BussinessServiceDao;
import zhongfucheng.utils.PrivilegeException;
import zhongfucheng.utils.ServiceDaoFactory;
import zhongfucheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ozc on 2017/4/12.
 */
@WebServlet(name = "CategoryServlet",urlPatterns = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BussinessServiceDao service = ServiceDaoFactory.getInstance().createDao("zhongfucheng.service.impl.BussinessServiceImpl", BussinessServiceDao.class, (User) request.getSession().getAttribute("user"));

        String method = request.getParameter("method");

        if (method.equals("add")) {
            try {
                //把浏览器带过来的数据封装到bean中
                Category category = WebUtils.request2Bean(request, Category.class);
                category.setId(WebUtils.makeId());

                service.addCategory(category);
                request.setAttribute("message", "添加分类成功！");

            } catch (Exception e) {
                if (e.getCause() instanceof PrivilegeException) {
                    request.setAttribute("message", e.getCause().getMessage());
                    e.printStackTrace();
                } else {
                    request.setAttribute("message","添加分类失败");
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/message.jsp").forward(request, response);
            }


        } else if (method.equals("find")) {

        } else if (method.equals("update")) {

        } else if (method.equals("look")) {

            try {
                List<Category> list = service.getAllCategory();
                request.setAttribute("list", list);
                request.getRequestDispatcher("/background/lookCategory.jsp").forward(request, response);
                return;

            } catch (Exception e) {
                if (e.getCause() instanceof PrivilegeException) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getCause().getMessage());
                    request.getRequestDispatcher("/message.jsp").forward(request, response);
                    return;
                }
            }
        } else {
            throw new RuntimeException("分类模块没有该操作！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
