package zhongfucheng.dao;

import zhongfucheng.domain.Privilege;
import zhongfucheng.domain.User;

import java.util.List;

/**
 * Created by ozc on 2017/4/16.
 */
public interface UserDao {
    void register(User user);

    User login(String username, String password);

    User find(String id);

    List<Privilege> findUserPrivilege(String user_id);
}
