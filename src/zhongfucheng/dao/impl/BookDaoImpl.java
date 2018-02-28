package zhongfucheng.dao.impl;

/**
 * Created by ozc on 2017/4/12.
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import zhongfucheng.domain.Book;

import zhongfucheng.utils.Utils2DB;

import java.sql.SQLException;
import java.util.List;

/**
 * 图书模块
 * 1：添加图书
 * 2：查看图书
 * 3：查找图书的分页数据【图书一般来说有很多，所以要分页】
 */
public class BookDaoImpl implements zhongfucheng.dao.BookDao {

    @Override
    public void addBook(Book book) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "INSERT INTO book (id,name,description,author,price,image,category_id) VALUES(?,?,?,?,?,?,?)";
        try {
            queryRunner.update(sql, new Object[]{book.getId(), book.getName(), book.getDescription(), book.getAuthor(), book.getPrice(),book.getImage(), book.getCategory_id()});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findBook(String id) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "SELECT * FROM book WHERE id=?";

        try {
            return (Book) queryRunner.query(sql, id, new BeanHandler(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**得到图书的分页数据*/
    @Override
    public List<Book> getPageData(int start, int end) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "SELECT * FROM book limit ?,?";

        try {
            return (List<Book>) queryRunner.query(sql, new BeanListHandler(Book.class), new Object[]{start, end});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**得到按照分类图书的分页数据*/
    @Override
    public List<Book> getPageData(int start, int end, String category_id) {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        //WHERE字句在limit字句的前边，注意Object[]的参数位置！
        String sql = "SELECT * FROM book WHERE category_id=? limit ?,?";

        try {
            return (List<Book>) queryRunner.query(sql, new BeanListHandler(Book.class), new Object[]{ category_id,start, end});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 得到图书的总记录数
     */
    @Override
    public long getTotalRecord() {
        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

        String sql = "SELECT COUNT(*) FROM book";

        try {
            return (long) queryRunner.query(sql, new ScalarHandler());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 得到分类后图书的总记录数
     * getCategoryTotalRecord
     */
    public long getCategoryTotalRecord(String category_id) {

        try {
            QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());

            String sql = "SELECT COUNT(*) FROM book WHERE category_id=?";
            return (long) queryRunner.query(sql, category_id, new ScalarHandler());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
