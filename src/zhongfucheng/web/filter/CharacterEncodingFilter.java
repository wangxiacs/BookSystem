package zhongfucheng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by ozc on 2017/4/12.
 */
@WebFilter(filterName = "CharacterEncodingFilter",urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(new MyRequest(request), response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }
}
class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;

    }
    @Override
    public String getParameter(String name) {

        String value = this.request.getParameter(name);
        if(value==null){
            return null;
        }
        if(!this.request.getMethod().equalsIgnoreCase("get")){
            return value;
        }
        try {
            value = new String(value.getBytes("iso8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
