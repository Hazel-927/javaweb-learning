package top.soft.bookonline.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import top.soft.bookonline.service.impl.BookServiceImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/10/26 14:49
 */
@WebServlet("/detail/*")
public class BookDetailServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, java.io.IOException {
        String requestPath = req.getRequestURI().trim();

        Pattern pattern = Pattern.compile("/detail/(\\d+)");
        Matcher matcher = pattern.matcher(requestPath);

        if (matcher.find()) {
            // 提取出其中的数字部分作为书籍编号
            String id = matcher.group(1);
            Book book = bookService.getBookById(Integer.parseInt(id));

            // 将获取到的书籍对象设置为名为 "book" 的请求属性，语义更清晰
            req.setAttribute("book", book);

            // 将请求转发到 book_detail.jsp 页面展示书籍详细信息
            req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
        } else {
            // 处理请求路径不符合预期的情况，比如返回错误页面或设置相应的错误提示信息
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request path for book detail.");
        }
//        int postion=requestPath.lastIndexOf("/");
//        String id=requestPath.substring(postion+1);
//        Book book=bookService.getBookById(Integer.parseInt(id));
//        req.setAttribute("bookList",book);
//        req.getRequestDispatcher("/book_detail.jsp").forward(req,resp);
    }
}
