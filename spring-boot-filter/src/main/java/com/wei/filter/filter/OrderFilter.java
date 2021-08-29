package com.wei.filter.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Order(2)
@WebFilter(urlPatterns = "/order/*",filterName = "orderFilter")
public class OrderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("orderFilter init.........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter start.........");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("doFilter end.........");
    }

    @Override
    public void destroy() {
        System.out.println("orderFilter destroy.........");
    }
}
