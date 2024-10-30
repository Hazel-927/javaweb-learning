package top.soft.class04cookiesession.cookie;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/10/19 14:17
 */
@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String value = "崇明";
        Cookie cookie = new Cookie("chinesename", URLEncoder.encode(value, StandardCharsets.UTF_8));
        resp.addCookie(cookie);
    }
}
