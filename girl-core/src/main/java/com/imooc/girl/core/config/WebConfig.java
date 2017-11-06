package com.imooc.girl.core.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hmh on 2017/11/6.
 */
@Configuration
// 添加@Configuration 注解，将自定义Filter加入过滤链
public class WebConfig {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName","paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    public class MyFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            //TODO
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("this is MyFilter, url:" + request.getRequestURI());
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {
             //TODO
        }
    }
}
