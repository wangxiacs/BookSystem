package zhongfucheng.utils;

/**
 * Created by ozc on 2017/4/12.
 */
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ozc on 2017/2/22.
 */
public class Utils2DB {

    private static ComboPooledDataSource comboPooledDataSource = null;

    static {

        //它会自动寻找配置文件，节点为mysql的数据库
        comboPooledDataSource = new ComboPooledDataSource();
    }


    public static DataSource getDataSource() {
        return comboPooledDataSource ;
    }

    public static Connection connection() {
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库初始化失败了！");
        }
    }
}
