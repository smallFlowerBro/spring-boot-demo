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
@Order(1)
@WebFilter(urlPatterns = "/user/*",filterName = "userFilter")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("userFilter init....................");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter start......................");
        long start = System.currentTimeMillis();

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("LogFilter execute cost:"+(System.currentTimeMillis()-start));
        System.out.println("doFilter end......................");
    }

    @Override
    public void destroy() {
        System.out.println("userFilter destroy....................");
    }
}
