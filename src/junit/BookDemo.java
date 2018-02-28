package junit;

import org.junit.Test;
import zhongfucheng.dao.BookDao;
import zhongfucheng.dao.impl.BookDaoImpl;
import zhongfucheng.domain.Book;

import java.util.List;

/**
 * Created by ozc on 2017/4/12.
 */
public class BookDemo {

    BookDao bookDao = new BookDaoImpl();


    @Test

    public void add() {
        Book book = new Book();
        book.setId("5");
        book.setName("SQLServer");
        book.setAuthor("我也不知道");
        book.setImage("33333332432");
        book.setPrice(33.22);
        book.setDescription("这是一本好书");
        book.setCategory_id("2");

        bookDao.addBook(book);
    }

    @Test
    public void look() {

        List<Book> bookList = bookDao.getPageData(3, 3);

        for (Book book : bookList) {
            System.out.println(book.getName());
        }

        List<Book> books = bookDao.getPageData(0,2,"2");

        for (Book book : books) {
            System.out.println(book.getName());

        }
    }
    @Test
    public void getRecord() {
        System.out.println(bookDao.getTotalRecord());
    }

    @Test
    public void find() {
        String id = "2";
        Book book = bookDao.findBook(id);

        System.out.println(book.getName());
    }


}
