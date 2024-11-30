package top.soft.class06filterlistener.filter;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/23 14:09
 */

//@WebFilter("/*")
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo02初始化");
    }

    @Override
    public void destroy() {
        System.out.println("销毁02过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        System.out.println("放行资源之前02执行");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("放行资源之后02执行");
    }
}