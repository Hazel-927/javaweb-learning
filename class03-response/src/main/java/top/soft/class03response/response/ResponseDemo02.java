package top.soft.class03response.response;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author dhl51
 * @description: 转发和重定向 测试
 * @date 2024/9/28 14:29
 */

@WebServlet("/responseDemo02")
public class ResponseDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/responseDemo01?username=zhangsan").forward(req,resp);
//        resp.sendRedirect("/responseDemo01?username=zhangsan");
        resp.sendRedirect("https://book.douban.com/#:~:text=%E8%89%BA%E6%9C%AF%EF%BC%8C%E8%A6%81%E4%B9%88%E6%8A%84%E8%A2%AD%EF%BC%8C%E8%A6%81%E4%B9%88");

    }
}
