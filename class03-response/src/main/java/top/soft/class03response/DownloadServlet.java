package top.soft.class03response;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author dhl51
 * @description: TODO
 * @date 2024/9/29 15:48
 */

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

//        response.sendRedirect("download.jsp");

        // 获取请求参数，⽂件名称
        String filename = request.getParameter("filename");

        // 找到⽂件服务器路径
        ServletContext servletContext = this.getServletContext();

        String realPath1 = servletContext.getRealPath("/sources/" + filename);
        String realPath2 = servletContext.getRealPath("/sources/" + filename);

        // ⽤字节流关联
        FileInputStream fis1 = new FileInputStream(realPath1);
        FileInputStream fis2 = new FileInputStream(realPath2);
        // 获取⽂件的 mime 类型
        String mimeType = servletContext.getMimeType(filename);

        // 设置响应头类型：content-type
        response.setHeader("content-type", mimeType);

        // 设置响应头打开⽅式:content-disposition
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        // 将输⼊流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len;
        while ((len = fis1.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        while ((len = fis1.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }

        fis1.close();
        fis2.close();
    }
}
