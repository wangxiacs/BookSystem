package junit;

import org.junit.Test;
import zhongfucheng.dao.UserDao;
import zhongfucheng.dao.impl.UserDaoImpl;
import zhongfucheng.domain.User;

/**
 * Created by ozc on 2017/4/16.
 */
public class UserDemo {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void add() {

        User user = new User();
        user.setId("1");
        user.setUsername("zhong");
        user.setPassword("123");
        user.setCellphone("10085");
        user.setAddress("广州萝岗");
        user.setEmail("40368324234234@QQ.com");

        userDao.register(user);
    }

    @Test
    public void find() {

        String id = "1";
        User user = userDao.find(id);

        System.out.println(user.getEmail());
    }

    @Test
    public void login() {
        String username = "zhong";
        String password = "123";
        User user = userDao.login(username, password);

        System.out.println(user.getAddress());
    }
}
