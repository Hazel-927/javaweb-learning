package top.soft.class04cookiesession.session;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/10/19 14:51
 */
@WebServlet("/sesssionDemo02")
public class SesssionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        System.out.println(username);
    }
}
