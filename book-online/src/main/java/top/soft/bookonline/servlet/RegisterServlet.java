package top.soft.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.RegisterService;
import top.soft.bookonline.service.impl.RegisterServiceImpl;
import top.soft.bookonline.util.JdbcUtil;
import top.soft.bookonline.util.Md5Util;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final RegisterService registerService;

    public RegisterServlet() {
        DataSource dataSource = JdbcUtil.getDataSource();
        registerService = new RegisterServiceImpl(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户在注册表单中输入的账号
        String account = request.getParameter("account");
        // 获取用户在注册表单中输入的密码
        String password = request.getParameter("password");
        System.out.println("获取到的密码值: " + password);
        // 使用构建器模式创建User对象
        User user = User.builder()
                .account(account)
                .password(password)
                .build();
        // 对密码进行MD5加密（假设此处调用加密逻辑，如果不考虑优化则可以保留原逻辑）
        String encryptedPassword = Md5Util.crypt(password);
        user.setPassword(encryptedPassword);
        // 调用注册服务进行注册操作
        User registeredUser = registerService.register(user);
        if (registeredUser != null) {
            // 注册成功，重定向到登录页面（这里假设登录页面的路径是/login）
            request.getRequestDispatcher("/login").forward(request, response);
        } else {
            // 注册失败，设置响应内容类型和编码
            response.setContentType("text/html;charset=UTF-8");
            // 向用户返回注册失败的提示信息
            response.getWriter().write("<script>alert('注册失败，账号可能已存在或稍后重试');location.href='/login-page';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 对于GET请求，直接调用doPost方法处理（如果有需要，也可以根据实际情况单独处理GET请求）
        this.doPost(request, response);
    }
}