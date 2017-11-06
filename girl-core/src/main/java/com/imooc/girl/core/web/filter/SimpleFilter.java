package com.imooc.girl.core.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by hmh on 2017/8/17.
 */
//@WebFilter(filterName = "/simpleFilter", urlPatterns = "/*", asyncSupported = true)
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("SimpleFilter.init()");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SimpleFilter.doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("SimpleFilter.destroy()");
    }
}
