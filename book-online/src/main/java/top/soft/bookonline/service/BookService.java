package top.soft.bookonline.service;


import top.soft.bookonline.entity.Book;

import java.util.List;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/10/26 14:09
 */

public interface BookService {
    /**
     * @return
     */
    List<Book> getbooks();

    Book getBookById(int id);
}
