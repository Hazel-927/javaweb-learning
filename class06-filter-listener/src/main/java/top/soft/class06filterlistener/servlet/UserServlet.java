package top.soft.class06filterlistener.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/23 13:58
 */
@WebServlet("/user/servlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("UserServlet被访问");
    }
}
