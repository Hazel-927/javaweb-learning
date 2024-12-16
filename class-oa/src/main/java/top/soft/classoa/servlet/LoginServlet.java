package top.soft.classoa.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.classoa.entity.User;
import top.soft.classoa.service.UserService;
import top.soft.classoa.utils.ResponseUtils;

import javax.security.auth.login.LoginException;
import java.io.IOException;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/30 15:51
 */
@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        // 接收用户输入，前端用表单键值对的形式传参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ResponseUtils result;

        try {
            User user = userService.login(username, password);

            // 盐值和密码敏感信息不返回给前端，也可以封装 VO 在 mapper 层直接返回UserVO
            user.setPassword(null);
            user.setSalt(null);

            // 响应结果，0代表处理成功，非0代表处理失败
            result = new ResponseUtils().put("user", user);
        } catch (LoginException e) {
            e.printStackTrace();
            // 登录失败，service 会执行，throw new LoginException 操作，并将失败原因返回给客户端
            result = new ResponseUtils(getClass().getSimpleName(), e.getMessage());
        }

        // 返回 JSON 结果
        resp.getWriter().write(result.toJsonString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
