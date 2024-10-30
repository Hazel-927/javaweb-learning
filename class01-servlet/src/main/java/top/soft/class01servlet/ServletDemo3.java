package top.soft.class01servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * @author dong hongliang
 * @data 2024-09-18
 * @deprecated 通过注解配置servlet
 */
@WebServlet(value = "/demo3", name = "demo3")
public class ServletDemo3 implements Servlet {
    /**
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo3初始化");
    }

    /**
     * 获取配置
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 执行Servlet方法
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("servletdemo3 执行");
        System.out.println("servletdemo3 执行");
    }

    /**
     * 获取Servlet信息
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 执行销毁方法
     */
    @Override
    public void destroy() {

        System.out.println("打印销毁方法");
    }
}