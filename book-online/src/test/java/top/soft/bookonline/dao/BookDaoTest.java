package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.BookDaoImpl;
import top.soft.bookonline.entity.Book;

import java.util.List;

class BookDaoTest {

    @Test
    void selectAll() {
        BookDao dao = new BookDaoImpl();
        List<Book> books = dao.selectAll();
        System.out.println(books.size());
    }

    @Test
    void getBookById() {
        Book book = new BookDaoImpl().getBookById(1);
        System.out.println(book);
    }
}