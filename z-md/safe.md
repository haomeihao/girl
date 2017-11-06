### 互联网安全架构

#### 常见的Web攻击手段

- XSS
    
        跨站脚本攻击(Cross Site Scripting)

- CSRF
    
        跨站请求伪造(cross site request forgery)
        
    1、CSRF的防御
    
        (1)将cookie设置为HttpOnly
         
        Java-Servlet                 
        response.setHeader("Set-Cookie", "cookiename=cookievalue;HttpOnly");
             
        (2)增加token
        HttpSession session = request.getSession();
        Object token = session.getAttribute("_token");
        if(token == null || "".equals(token)) {
            session.setAttribute("_token", UUID.randomUUID().toString);
        }
        
        (3)通过Referer识别
        String referer = request.getHeader("Referer");
                         
- SQL注入

    1、SQL注入的防范
        
        (1)使用预编译语句
        即占位符? ? 
        st.setString(1, nickname)
        st.setString(2, password)
        
        (2)使用ORM框架
        iBatis、Hibernate
        <insert id="insert" parameterClass="UserDO">
            insert into 
            users(gmt_create, gmt_modified, userid, user_nick, address, age, sex)
            values(now(), now(), #userId#, #userNick#, #address#, #age#, #sex#)
        </insert>

        (3)密码加密
        单向Hash,MD5,彩虹表，碰撞串;
        哈希加盐法(Hahs+Salt)
        password=hello+随机字符串abcdefjejafljal
        再MD5
        
        (4)处理好相应的异常
        
- 文件上传漏洞
      
    1、对文件类型进行白名单校验
    
        不能简单通过文件后缀名判断文件类型，根据文件开始的几个字节
        确定文件类型，这几个字节也被称为魔教(magic number)
        
    
    2、限制上传文件的大小
    3、上传的文件进行重新命名(包括路径)
        
        

- DDos攻击

        DDoS(Distributed Denial of Service)
        -> 分布式拒绝服务攻击
        
        Dos攻击利用合理的客户端请求来占用过多的服务器资源。
        DDos是攻击者借助公共网络，将数量庞大的计算机设备联合起来作为攻击平台，
        对一个或多个目标发起攻击，从而达到瘫痪目标主机的目的。
        
        肉鸡。
        
        DDos攻击类型很多：
            依赖蛮力的ICMP Flood, UDP Flood，现在不常见。
            依赖协议特征和具体的软件漏洞进行的攻击，如Slowloris攻击，Hash碰撞攻击，
            这类攻击主要利用协议和软件漏洞发起攻击，需要在特定环境下才会出现。
            更多的攻击者采用的是前面两种的混合方式，即利用了协议、系统的缺陷，又具备了
            海量的流量，如SYN Flood,DNS Query Flood等。
            
    1、SYN Flood
        
        互联网最经典的攻击方式之一，TCP协议建立连接的过程，
        
        No.1 Client -> Server : 一个包含SYN标识的TCP报文，SYN(Synchronize)的意思，SYN报文
            会指明客户端的端口号及TCP连接的初始序列号。
        No.2 Client <- Server : 返回一个SYN+ACK的报文，表示客户端请求被接收，同时TCP序列号被+1，
            ACK即确认的意思(Acknowledgment)
        No.3 Client -> Server : 返回一个ACK报文，TCP序列号+1，TCP连接便建立好了。
            
        -> 三次握手(Three-way Handshake)
            
        SYN Flood 正式利用了TCP协议三次握手的过程来达成攻击的目的。
        攻击者伪造大量的IP地址给服务器发送SYN报文，但是伪造的IP地址几乎不可能存在，也就不可能
        从客户端得到任何回应，服务器将维护一个非常大的半连接等待列表，并且不断对这个列表中的IP地址
        进行遍历和重试，占用了大量的系统资源。更为严重的是，由于服务器资源有限，大量的恶意客户端
        信息占满了服务器的等待队列，导致服务器不再接收新的SYN请求，正常用户无法完成三次握手与服务器
        进行通信，这便是SYN Flood攻击。
        
    2、DNS Query Flood
    
        UDP Flood攻击的一种变形，一旦DNS服务器瘫痪，影响甚大。
        向被攻击的服务器发送海量的域名解析请求。请求解析的域名是随机生成的，大部分根本不存在。
        并且通过伪造端口和客户端IP，防止查询请求被ACL(访问控制列表Access Control List)过滤。
        当解析请求超过一定量时，就会造成DNS服务器解析域名超时，这样攻击者便达成了攻击目的。
        
    3、CC攻击
            
        CC(Challenge Collapsar)攻击属于DDos的一种，是基于应用层HTTP协议发起的DDos攻击，也被称为
        HTTP Flood。
        CC攻击的原理是这样的，攻击者通过控制大量肉鸡或者利用从互联网上搜寻的大量匿名的HTTP代理，
        模拟正常用户给网站发起请求直到该网站拒绝服务为止。
        
- 其他攻击手段

    DNS域名劫持，CDN回源攻击、服务器权限提升，缓冲区溢出，以及一些依赖于平台或者具体软件漏洞的攻击等。
    防御的滞后性使得攻击的手段永远比防御的手段多。
    

#### 常用的安全算法

        摘要算法、对称加密算法、非对称加密算法、信息编码等。      
           
- 数字摘要

        也称消息摘要，单向Hash函数，验证消息的完整性。
        消息摘要采用单向Hash函数，将需要计算的内容“摘要”成固定长度的串，
        这个串也称为数字指纹。
        k hash函数=f(x) k摘要为f(k),若关键字k1!=k2，而f(k1)=f(k2),称为Hash碰撞。
        摘要的长度越长，算法也就越安全。
                                                     

                                                                
        
            
            
              
        
        