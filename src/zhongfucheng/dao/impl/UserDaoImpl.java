package zhongfucheng.dao.impl;

/**
 * Created by ozc on 2017/4/16.
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zhongfucheng.domain.Privilege;
import zhongfucheng.domain.User;
import zhongfucheng.utils.Utils2DB;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户的登录注册模块
 * 1：登陆
 * 2：注册
 * 3：根据id查找具体的用户
 */
public class UserDaoImpl implements zhongfucheng.dao.UserDao {



    @Override
    public void register(User user) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "INSERT INTO user (id,username,cellphone,address,email,password) VALUES(?,?,?,?,?,?)";
        try {

            queryRunner.update(sql, new Object[]{user.getId(),user.getUsername(), user.getCellphone(), user.getAddress(), user.getEmail(), user.getPassword()});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User login(String username, String password) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "SELECT * FROM user WHERE username = ? AND password=?";
        try {

            return (User) queryRunner.query(sql, new Object[]{username, password}, new BeanHandler(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User find(String id) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "SELECT * FROM user WHERE id=?";
        try {

            return (User) queryRunner.query(sql, id, new BeanHandler(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Privilege> findUserPrivilege(String user_id) {
        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "SELECT p.* FROM privilege p, user_privilege up WHERE p.id = up.privilege_id AND up.user_id = ?";
        try {
            return (List<Privilege>) queryRunner.query(sql, new Object[]{user_id}, new BeanListHandler(Privilege.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
