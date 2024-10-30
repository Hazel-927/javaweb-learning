package top.soft.class03response.response;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author dhl51
 * @description: Response 对象
 * @date 2024/9/28 13:57
 */
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        System.out.println("responseDemo01被请求");
        if (username.equals("zhangsan")) {
            resp.setStatus(200);
        } else {
            resp.setStatus(404);
        }
    }
}
