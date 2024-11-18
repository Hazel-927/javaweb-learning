package top.soft.brandlist.servlet;


import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.brandlist.entity.Brand;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/16 16:37
 */
@WebServlet("/deleteBrand")
public class DeleteBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用缓冲字符流来读取请求体数据
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = req.getReader();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        // 将JSON字符串转换为包含品牌id的简单对象
        DeleteBrandRequest deleteBrandRequest = JSON.parseObject(sb.toString(), DeleteBrandRequest.class);
        // 从ServletContext中获取品牌数据集合
        List<Brand> brands = (List<Brand>) req.getServletContext().getAttribute("brands");
        if (brands != null) {
            // 查找要删除的品牌对象并删除
            brands.removeIf(brand -> brand.getId().equals(deleteBrandRequest.getId()));
            // 将更新后的品牌集合重新设置回ServletContext
            req.getServletContext().setAttribute("brands", brands);
            // 设置响应状态码为200，表示成功
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("品牌删除成功");
        } else {
            // 如果品牌集合不存在，设置响应状态码为500，表示服务器内部错误
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("服务器内部错误，品牌数据获取失败");
        }
    }

    // 定义一个内部类，用于接收从客户端传递过来的包含品牌id的JSON数据转换后的对象
    private static class DeleteBrandRequest {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
