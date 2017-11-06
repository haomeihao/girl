### Docker

#### 基本概念

        Docker 包括三个基本概念
        
        镜像（Image）
        容器（Container）
        仓库（Repository）
        
        理解了这三个概念，就理解了 Docker 的整个生命周期。
    
#### 安装Docker
    
    
    
#### 使用镜像        
    
1、获取镜像
    
        docker pull ubuntu:14.04
        
        docker run -it --rm ubuntu:14.04 bash
        
        cat /etc/os-release
        lsb_release -a
        uname -a
        cat /proc/version
        
2、列出镜像
    
        docker images
        
        docker images -f dangling=true
        
        docker rmi $(docker images -q -f dangling=true)
        
        docker images -a
        
        docker images ubuntu
        
        docker images ubuntu:16.04
        
        docker images -f since=mongo:3.2
        
        docker images -f label=com.example.version=0.1
        
        docker images -q
        
        docker images --format "{{.ID}}: {{.Repository}}"
        
        docker images --format "table {{.ID}}\t{{.Repository}}\t{{.Tag}}"
 
3、定制镜像（利用commit理解镜像构成）
        
        docker run --name webserver3 -d -p 8003:80 nginx
        
        docker exec -it webserver3 bash
        
            root@3729b97e8226:/# echo '<h1>Hello, Docker!</h1>' > /usr/share/nginx/html/index.html
        
        docker diff webserver3
        
        docker commit \
            --author "shaochuan hao <shaochuanhao2015@gmail.com>" \
            --message "update nginx/html/index.html" \
            webserver3 \
            nginx:v2
        
        docker images nginx
        
        docker history nginx:v2
        
        docker run --name web4 -d -p 8004:80 nginx:v2
        
        **慎用 docker commit**
        
        docker commit 命令除了学习之外，还有一些特殊的应用场合，比如被入侵后保存现场等。
        但是，不要使用 docker commit 定制镜像，定制行为应该使用 Dockerfile 来完成。
        
#### 操作容器
        
1、启动容器

    启动容器
        
        启动容器有两种方式，
        一种是基于镜像新建一个容器并启动，
        另外一个是将在终止状态（stopped）的容器重新启动。
        因为 Docker 的容器实在太轻量级了，很多时候用户都是随时删除和新创建容器。
        
    新建并启动
            
        docker run
        
        sudo docker run ubuntu:14.04 /bin/echo 'Hello world'
        
        sudo docker run -t -i ubuntu:14.04 /bin/bash
      
    启动已终止容器
        
        docker start
        
        可以在伪终端中利用 ps 或 top 来查看进程信息。
        
2、后台(background)运行

        sudo docker run ubuntu:14.04 /bin/sh -c "while true; do echo hello world; sleep 1; done" 
    
        sudo docker run -d ubuntu:14.04 /bin/sh -c "while true; do echo hello world; sleep 1; done"
    
        docker ps
        
        docker logs [container ID or NAMES]
       
3、终止容器
        
        docker stop
        
        终止状态的容器可以用 docker ps -a 命令看到。
        
        处于终止状态的容器，可以通过 docker start 命令来重新启动。
        
        docker restart 命令会将一个运行态的容器终止，然后再重新启动它。
        
4、进入容器     

        在使用 -d 参数时，容器启动后会进入后台。 
        某些时候需要进入容器进行操作，有很多种方法，
        包括使用 docker attach 命令或 nsenter 工具等。
        
    attach 命令
    
        docker run -idt ubuntu
        
        docker ps
        
        docker attach thirsty_beaver
      
    nsenter 命令
        
        $ 
        wget https://www.kernel.org/pub/linux/utils/util-linux/v2.29/util-linux-2.29.tar.xz
        tar xJvf util-linux-2.29.tar.xz
        $ 
        cd util-linux-2.29
        $ 
        ./configure --without-ncurses
        make nsenter
        $ 
        cp nsenter /usr/local/bin
        
        
        $ 
        wget -P ~ https://github.com/yeasy/docker_practice/raw/master/_local/.bashrc_docker
        $ 
        echo "[ -f ~/.bashrc_docker ] 
        . ~/.bashrc_docker" >> ~/.bashrc
        source ~/.bashrc
        
        $ echo $(docker-pid <container>)
        $ docker-enter <container> 
        
5、导出和导入容器
        
    导出容器
        
        docker export
        
        docker export 7691a814370e > ubuntu.tar
    
    导入容器快照
        
        docker import
        
        cat ubuntu.tar | docker import - test/ubuntu:v1.0
        
        REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
        test/ubuntu         v1.0                dc4a72213a08        5 seconds ago       97.9MB
        
        docker import http://example.com/exampleimage.tgz example/imagerepo
                
6、删除容器
                
    docker rm <container>
                    
    docker rm $(docker ps -a -q)
                        
#### 访问仓库
                        
1、Docker Hub

    登录

        docker login

        注册成功后，本地用户目录的 .dockercfg 中将保存用户的认证信息。

    基本操作
    
        docker search

        在查找的时候通过 -s N 参数可以指定仅显示评价为 N 星以上的镜像（新版本Docker推荐使用--filter=stars=N参数）。

        docker pull                            

        docker push

    自动创建

2、私有仓库

        docker-registry 是官方提供的工具，可以用于构建私有的镜像仓库。

安装运行 docker-registry    

    容器运行

        docker run -d -p 5000:5000 registry

        docker run \
         -e SETTINGS_FLAVOR=s3 \
         -e AWS_BUCKET=acme-docker \
         -e STORAGE_PATH=/registry \
         -e AWS_KEY=AKIAHSHB43HS3J92MXZ \
         -e AWS_SECRET=xdDowwlK7TJajV1Y7EoOZrmuPEJlHYcNP2k4j49T \
         -e SEARCH_BACKEND=sqlalchemy \
         -p 5000:5000 \
         registry

        docker run -d -p 5000:5000 -v /home/user/registry-conf:/registry-conf -e DOCKER_REGISTRY_CONFIG=/registry-conf/config.yml registry

        docker run -d -p 5000:5000 -v /opt/data/registry:/var/lib/registry registry
    
    本地安装

        Ubuntu
        $ sudo apt-get install -y build-essential python-dev libevent-dev python-pip liblzma-dev
        $ sudo pip install docker-registry

        CentOS
        $ sudo yum install -y python-devel libevent-devel python-pip gcc xz-devel
        $ sudo python-pip install docker-registry    

        $ sudo apt-get install build-essential python-dev libevent-dev python-pip libssl-dev liblzma-dev libffi-dev
        $ git clone https://github.com/docker/distribution
        $ cd distribution
        $ docker build .

        docker run -d -p 5000:5000 --restart=always --name registry ${IMAGE_ID}

    在私有仓库上传、下载、搜索镜像    

        

        
        
        
        

            
            
        