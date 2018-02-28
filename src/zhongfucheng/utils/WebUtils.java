package zhongfucheng.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

/**
 * Created by ozc on 2017/4/12.
 */
public class WebUtils {
    public static <T> T request2Bean(HttpServletRequest httpServletRequest, Class<T> aClass) {


        try {
            //对于日期而言，是需要日期转换器的
            ConvertUtils.register(new DateLocaleConverter(), Date.class);

            //获取Bean的对象
            T bean = aClass.newInstance();

            httpServletRequest.setCharacterEncoding("UTF-8");

            //获取表单中所有的名字
            Enumeration enumeration = httpServletRequest.getParameterNames();

            //遍历表单提交过来的名字
            while (enumeration.hasMoreElements()) {

                //每个名字
                String name = (String) enumeration.nextElement();

                //获取得到值
                String value = httpServletRequest.getParameter(name);

                //如果用户提交的数据不为空，那么将数据封装到Bean中
                if (!value.equals("") && value != null) {
                    BeanUtils.setProperty(bean, name, value);
                }
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("封装数据到Bean中，失败了！");
        }
    }

    public static String makeId() {
        return UUID.randomUUID().toString();
    }

}
