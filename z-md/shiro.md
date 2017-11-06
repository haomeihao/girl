### Shiro

#### Apache Shiro Features 特性
 
        Authentication（认证）, 
        Authorization（授权）,
        Session Management（会话管理）,
        Cryptography（加密）
        被 Shiro 框架的开发团队称之为应用安全的四大基石。
        
        Authentication（认证）：用户身份识别，通常被称为用户“登录”
        
        Authorization（授权）：访问控制。比如某个用户是否具有某个操作的使用权限。
        
        Session Management（会话管理）：特定于用户的会话管理,甚至在非web 或 EJB 应用程序。
        
        Cryptography（加密）：在对数据源使用加密算法加密的同时，保证易于使用。
        
#### High-Level Overview 高级概述
    
        在概念层，Shiro 架构包含三个主要的理念：
        Subject,SecurityManager和 Realm。
        
        Subject：当前用户，Subject 可以是一个人，但也可以是第三方服务、守护进程帐户、时钟守护任务或者其它–当前和软件交互的任何事件。
        
        SecurityManager：管理所有Subject，SecurityManager 是 Shiro 架构的核心，配合内部安全组件共同组成安全伞。
        
        Realms：用于进行权限信息的验证，我们自己实现。Realm 本质上是一个特定的安全 DAO：它封装与数据源连接的细节，得到Shiro 所需的相关的数据。
        在配置 Shiro 的时候，你必须指定至少一个Realm 来实现认证（authentication）和/或授权（authorization）。
        
#### RBAC 基于角色的访问控制（Role-Based Access Control）
    
    在 RBAC 中，权限与角色相关联，用户通过成为适当角色的成员而得到这些角色的权限。
    这就极大地简化了权限的管理。
    这样管理都是层级相互依赖的，权限赋予给角色，而把角色又赋予用户，这样的权限设计很清楚，管理起来很方便。