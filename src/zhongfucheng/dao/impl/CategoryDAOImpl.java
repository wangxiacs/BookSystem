package zhongfucheng.dao.impl;

/**
 * Created by ozc on 2017/4/12.
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import zhongfucheng.domain.Category;
import zhongfucheng.utils.Utils2DB;

import java.sql.SQLException;
import java.util.List;

/**
 * 分类模块
 *  1：添加分类
 *  2：查找分类
 *  3：修改分类
 *
 *
 * */
public class CategoryDAOImpl implements zhongfucheng.dao.CategoryDao {

    @Override
    public void addCategory(Category category) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "INSERT INTO category (id, name, description) VALUES(?,?,?)";
        try {
            queryRunner.update(sql, new Object[]{category.getId(), category.getName(), category.getDescription()});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findCategory(String id) {
        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());
        String sql = "SELECT * FROM category WHERE id=?";

        try {
            Category category = (Category) queryRunner.query(sql, id, new BeanHandler(Category.class));

            return category;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Category> getAllCategory() {
        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());
        String sql = "SELECT * FROM category";

        try {
            List<Category> categories = (List<Category>) queryRunner.query(sql, new BeanListHandler(Category.class));

            return categories;
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }

    }
}
