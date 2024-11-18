package top.soft.bookonline;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author dhl51
 * @description: 验证码生成和验证
 * @date 2024/9/28 16:07
 */

@WebServlet("/verifyCode")
public class VerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        // 声明一个字符串变量来存储验证码
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(code.length());
            char c = code.charAt(index);

            // 将生成的字符添加到字符串变量中
            sb.append(c);

            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            graphics.setColor(color);
            Font font = new Font("Dialog", Font.BOLD, 30);
            graphics.setFont(font);
            graphics.drawString(String.valueOf(c), width / 5 * i, height / 2);
        }

        // 将验证码存储在会话中
        req.getSession().setAttribute("verifyCode", sb.toString());

        for (int i = 0; i < 11; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            graphics.setColor(color);
            graphics.drawLine(x1, y1, x2, y2);
        }

        // 设置响应内容类型
        resp.setContentType("image/jpeg");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);

        // 写入图片并关闭输出流
        try (ImageOutputStream output = ImageIO.createImageOutputStream(resp.getOutputStream())) {
            ImageIO.write(image, "jpg", output);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型为JSON格式，因为要返回验证结果给前端
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // 获取前端发送过来的验证码（假设前端发送的数据格式为"verifyCode=用户输入的验证码"）
        String userVerifyCode = req.getParameter("verifyCode");

        // 从会话中获取之前存储的验证码（在doGet方法中生成并存储的）
        String storedVerifyCode = (String) req.getSession().getAttribute("verifyCode");

        // 进行验证码对比
        boolean isVerifyCodeCorrect = userVerifyCode != null && userVerifyCode.equalsIgnoreCase(storedVerifyCode);

        // 根据对比结果构建JSON数据
        String jsonResponse;
        if (isVerifyCodeCorrect) {
            jsonResponse = "{\"status\":\"success\"}";
        } else {
            jsonResponse = "{\"status\":\"failure\",\"message\":\"验证码错误，请重新输入。\"}";
        }

        // 将JSON数据返回给前端
        PrintWriter out = resp.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}
