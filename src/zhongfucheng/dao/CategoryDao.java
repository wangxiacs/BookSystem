package zhongfucheng.dao;

import zhongfucheng.domain.Category;

import java.util.List;

/**
 * Created by ozc on 2017/4/12.
 */
public interface CategoryDao {
    void addCategory(Category category);

    Category findCategory(String id);

    List<Category> getAllCategory();
}
