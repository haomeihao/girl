### Spring MVC 

#### 总体设计

        web.xml：
        org.springframework.web.servlet.DispatcherServlet
        
        MVC组件：
        核心组件：
            HandlerMapping：定义URL映射规则
            HandlerAdapter：实现业务逻辑的Handler实例对象
            ViewResolver：渲染模板资源
            
#### Control设计

    HandlerMapping：负责映射用户的URL和对应的处理类
    默认使用BeanNameUrlHandlerMapping
    SimpleUrlHandlerMapping
    
    --------
    
    HandlerAdapters：完成URL和Handler的映射关系
    SimpleServletHandlerAdapter：可继承HttpRequestHandler接口
    SimpleControllerHandlerAdapter：可以继承Controller接口
    SimpleServletHandlerAdapter：可继承Servlet接口
    
#### Model设计
    
    如Handler对象返回ModelAndView对象，说明Handler需要传入一个Model实例给View去渲染模板。
    ModelAndView对象是连接业务逻辑层与View展现层的桥梁，对Spring MVC来说它是
    连接Handler与View的桥梁
    
#### View设计    

#### 框架设计的思考

    最基本的原则：
    OCP(开闭原则)
    LSP(里氏代换原则)
    DIP(依赖倒转原则)
    ISP(接口隔离)
    CARP(合成/聚合复用)
    LOD(迪米特原则)