package top.soft.class03response.response;

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
 * @description: TODO响应类型
 * @date 2024/9/28 14:55
 */

@WebServlet("/res")
public class ResponseTypeDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String type = req.getParameter("type");
        System.out.println(type);
        switch (type) {
            case "image":
                getImage(req, resp);
                break;
            case "pdf":
                getPdf(req, resp);
                break;
            case "txt":
                getText(req, resp);
                break;
            default:
                break;
        }
    }

    private void getText(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/txt");
        String realPath3 = req.getServletContext().getRealPath("/txts/512927.txt");
        File file3 = new File(realPath3);
        InputStream in3 = new FileInputStream(file3);

        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in3.read()) != -1) {
            out.write(read);
        }
        in3.close();
        out.flush();
        out.close();
    }


    private void getPdf(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/pdf");
        String realPath2 = req.getServletContext().getRealPath("/pdfs/fdp.pdf");
        File file2 = new File(realPath2);
        InputStream in2 = new FileInputStream(file2);

        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in2.read()) != -1) {
            out.write(read);
        }
        in2.close();
        out.flush();
        out.close();
    }

    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/png");
        String realPath1 = req.getServletContext().getRealPath("/images/image.png");
        File file1 = new File(realPath1);
        InputStream in1 = new FileInputStream(file1);

        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in1.read()) != -1) {
            out.write(read);
        }
        in1.close();
        out.flush();
        out.close();
    }
}
