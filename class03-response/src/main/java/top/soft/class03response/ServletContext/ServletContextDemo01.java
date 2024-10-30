package top.soft.class03response.ServletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author dhl51
 * @description: TODO获取ServletContext对象
 * @date 2024/9/28 16:37
 */

@WebServlet("/servletContextDemo01")
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext context = req.getServletContext();
        ServletContext context1 = this.getServletContext();
        System.out.println(context.equals(context1));
    }
}
