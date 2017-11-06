package com.imooc.girl.core.web.config;


import com.imooc.girl.core.web.filter.SimpleFilter;
import com.imooc.girl.core.web.listener.SimpleListener;
import com.imooc.girl.core.web.servlet.SimpleServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Created by hmh on 2017/8/17.
 */
//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ServletRegistrationBean getDemoServlet() {
        SimpleServlet demoServlet = new SimpleServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(demoServlet);
        List<String> urlMappings = new ArrayList<String>();
        urlMappings.add("/demoservlet");////访问，可以添加多个
        registrationBean.setUrlMappings(urlMappings);
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean getDemoFilter() {
        SimpleFilter demoFilter = new SimpleFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(demoFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");//拦截路径，可以添加多个
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<EventListener> getDemoListener() {
        ServletListenerRegistrationBean<EventListener> registrationBean
                = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new SimpleListener());
//		registrationBean.setOrder(1);
        return registrationBean;
    }
}
