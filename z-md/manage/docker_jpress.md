### Docker JPress deploy

        1、Dockerfile

        2、docker build

        3、JPress：http://jpress.io/

        docker pull hub.c.163.com/library/tomcat:latest

        docker pull hub.c.163.com/library/mysql:latest

        
        
        vim Dockerfile
        
            from hub.c.163.com/library/tomcat
            
            MAINTAINER shaochuanhao shaochuanhao2015@gmail.com
            
            COPY jpress.war /usr/local/tomcat/webapps
            
        docker build -t jpress:latest .    
            
        docker run -d -p 8888:8080 jpress
        netstat -na|grep 8888  
          
          
        docker run -d -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=jpress hub.c.163.com/library/mysql:latest
