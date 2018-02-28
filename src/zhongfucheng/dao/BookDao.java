package zhongfucheng.dao;

import zhongfucheng.domain.Book;

import java.util.List;

/**
 * Created by ozc on 2017/4/12.
 */
public interface BookDao {
    void addBook(Book book);

    Book findBook(String id);

    List<Book> getPageData(int start, int end);

    List<Book> getPageData(int start, int end, String category_id);

    long getTotalRecord();

    long getCategoryTotalRecord(String category_id);
}
