### Spring框架

#### 1、Spring骨骼架构

        核心组件Core,Context,Bean

        特性功能Web,Transaction,AOP,JDBC,JMX,Orm...
    
- Spring的设计理念
        
        Bean是Spring的核心，Spring就是面向Bean编程的。
        把对象之间的依赖关系转而用配置文件来管理，也就是依赖注入。
        这个注入关系在一个叫IoC的容器中管理，IoC就是被Bean包裹的对象。

- 核心组件如何协同工作

        Bean是演员，Context舞台背景，Core演出道具。
        Context就是Bean关系的集合，这个关系的集合又叫IoC容器。
        Core就是发现，建立和维护每个Bean之间的关系所需要的一系列工具，Core组件叫Util更容易理解。
        
### 2、核心组件讲解

- Bean组件

        org.springframework.beans：
        Bean的定义，Bean的创建，对Bean的解析。
        对使用者来说唯一关系的是Bean的创建。
        
        Spring Bean的创建是典型的工厂模式，顶级接口BeanFactory，

- Context组件

        org.springframework.context：
        实际就是给Spring提供一个运行时的环境，用以保存各个对象的状态。
        ApplicationContext是Context的顶级父类。
        
- Core组件
   
        定义了资源的访问方式，把资源的加载、解析和资源的定义整合在一起便于其他组件使用。
        
- IoC容器如何工作
   
   1、如何创建工厂
   
        IoC容器是Context组件结合其他两个组件共同构成了一个Bean关系网，如何构建这个关系网？
        构建入口就在AbstractApplicationContext的refresh方法
        
   4、IoC容器如何为我所用
        
        ApplicatonContext.xml就是IoC容器的默认配置文件，Spring的所有特性都是基于IoC容器工作的，如AOP。
        
#### 3、Spring中AOP特性详解
  
- 动态代理的实现原理
    
        AOP基于动态代理实现的，动态代理要从JDK本身说起。
        java.lang.reflect包下有个Proxy类，构造代理类的入口。
        
- Spring AOP如何实现

        ...
        
#### 4、设计模式解析之代理模式

- 代理模式原理

        Subject:
        ProxySubject:
        RealSubject:
        
- Spring中代理模式的实现

        
#### 5、设计模式解析之策略模式

- 策略模式原理

        Context:
        Strategy:
        ConcreteStrategy:
       
- Spring中策略模式的实现

        

        



