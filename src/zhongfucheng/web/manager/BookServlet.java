package zhongfucheng.web.manager;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import zhongfucheng.domain.Book;
import zhongfucheng.domain.Category;
import zhongfucheng.domain.Page;
import zhongfucheng.service.BussinessServiceDao;
import zhongfucheng.service.impl.BussinessServiceImpl;
import zhongfucheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ozc on 2017/4/12.
 */
@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        BussinessServiceDao service = new BussinessServiceImpl();

        if (method.equals("addUI")) {

            List<Category> list = service.getAllCategory();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/background/addBook.jsp").forward(request, response);

        } else if (method.equals("add")) {

            //上传文件和普通数据分割开，封装到Book对象上
            Book book = uploadData(request);

            book.setId(WebUtils.makeId());
            service.addBook(book);
            request.setAttribute("message", "添加图书成功");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } else if (method.equals("look")) {

            String currentPageCount = request.getParameter("currentPageCount");
            Page page = service.getPageData(currentPageCount);

            request.setAttribute("page",page);
            request.getRequestDispatcher("/background/listBook.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

    private Book uploadData(HttpServletRequest request) {

        Book book = new Book();
        try{

            //1.得到解析器工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            //2.得到解析器
            ServletFileUpload upload = new ServletFileUpload(factory);

            //设置编码
            upload.setHeaderEncoding("UTF-8");


            //为上传表单，则调用解析器解析上传数据
            List<FileItem> list = upload.parseRequest(request);  //FileItem

            //遍历list，得到用于封装第一个上传输入项数据fileItem对象
            for(FileItem item : list){

                if(item.isFormField()){

                    //得到的是普通输入项
                    String name = item.getFieldName();  //得到输入项的名称
                    String value = item.getString("UTF-8");

                    //使用BeanUtils封装数据
                    BeanUtils.setProperty(book, name, value);
                }else{

                    //得到上传输入项

                    //得到上传文件名全路径
                    String filename = item.getName();

                    //截取文件名
                    filename = filename.substring(filename.lastIndexOf("\\")+1);

                    InputStream in = item.getInputStream();   //得到上传数据

                    int len = 0;
                    byte buffer[]= new byte[1024];

                    //如果没有这个目录，就创建它
                    String savepath = this.getServletContext().getRealPath("/image");
                    File file = new File(savepath);
                    if (!file.exists()) {
                        file.mkdir();
                    }

                    FileOutputStream out = new FileOutputStream(savepath + "\\" + filename);
                    while((len=in.read(buffer))>0){
                        out.write(buffer, 0, len);
                    }
                    //设置图片的名字
                    book.setImage(filename);

                    in.close();
                    out.close();

                    //关闭临时文件
                    item.delete();
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
}
