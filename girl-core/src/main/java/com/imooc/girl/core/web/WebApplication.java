//package com.imooc.core.web;
//
//import com.imooc.core.web.servlet.AsyncServlet;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
///**
// * Created by hmh on 2017/8/17.
// */
//@SpringBootApplication
////@ServletComponentScan
//public class WebApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(WebApplication.class, args);
//    }
//
//    /**
//     * 注册Servlet.不需要添加注解：@ServletComponentScan
//     *
//     * @return
//     */
////    @Bean
////    public ServletRegistrationBean AsyncServlet1() {
////        return new ServletRegistrationBean(new AsyncServlet(), "/asyncServlet1.do");
////    }
//
//
//    /**
//     * 修改DispatcherServlet默认配置，DispatcherServlet 默认拦截"/"
//     *
//     * @param dispatcherServlet
//     * @return
//     */
////    @Bean
////    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
////        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
////
////        registration.getUrlMappings().clear();
////        registration.addUrlMappings("*.do");
////        registration.addUrlMappings("*.json");
////
////        return registration;
////    }
//}
