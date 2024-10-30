package top.soft.class03response.ServletContext;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author dhl51
 * @description: TODO通过获取文件内容
 * @date 2024/9/28 16:47
 */
@WebServlet("/servletContextDemo02")
public class ServletContextDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext context = req.getServletContext();

        resp.setContentType("text/html;charset=utf-8");

        String aPath = context.getRealPath("/a.txt");
        System.out.println(aPath);

        String bPath = context.getRealPath("/WEB-INF/b.txt");
        System.out.println(bPath);

        String cPath = context.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(cPath);

        File file = new File(cPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        in.close();
        out.flush();
        out.close();
    }
}
