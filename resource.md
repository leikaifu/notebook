http协议
Content-Type 常用的7种类型:
常用的格式：>
 1，text/html 文本方式的html
 2，text/plain 纯文本
 3、text/xml 文本方式的xml
 4，application/x-www-from-urlencoded 表单提交（普通表单，非上传）
 5，application/json 数据以json形式编码
 6，application/xml 数据以xml形式编码
 7，multipart/form-data 表单上传图片、文件类型等附件时必须用该类型> 容易混淆的是4 
 和 7 ，如果不理解这个，会搞不清什么时候用4 什么时候用7

详情：https://blog.csdn.net/ios_xumin/article/details/52944366

常见的媒体格式类型如下：
    text/html ： HTML格式
    text/plain ：纯文本格式      
    text/xml ：  XML格式
    image/gif ：gif图片格式    
    image/jpeg ：jpg图片格式 
    image/png：png图片格式

以application开头的媒体格式类型：
   application/xhtml+xml ：XHTML格式
   application/xml     ： XML数据格式
   application/atom+xml  ：Atom XML聚合格式    
   application/json    ： JSON数据格式
   application/pdf       ：pdf格式  
   application/msword  ： Word文档格式
   application/octet-stream ： 二进制流数据（如常见的文件下载）
   application/x-www-form-urlencoded ： <form encType=””>中默认的encType，form表单数据被编码为key/value格式发送到服务器（表单默认的提交数据的格式）
   另外一种常见的媒体格式是上传文件之时使用的：

    multipart/form-data ： 需要在表单中进行文件上传时，就需要使用该格式
     以上就是我们在日常的开发中，经常会用到的若干content-type的内容格式。

Okhttp资源：


                                       Linux refer to resource

linux系统下安装tomcat遇见的问题：
错误：Cannot find /usr/local/tomcat/bin/setclasspath.sh（报这样的错误只需要运行下面的命令就OK了）
执行语句：unset CATALINA_HOME  
即可解决错误

1、开启防火墙
vi /etc/sysconfig/iptables
添加开放8080端口
2、重启防火墙
service iptables restart

ls -al 查看所有文件包括隐藏格式的文件。

linux系统下
首先，用ps查看进程，方法如下：
ps -ef
ps -ef | grep firefox
kill -s 9 1827

执行以下命令，可以只查看正在运行的服务：
# service --status-all | grep running

8.设置环境变量
打开profile文件：vi /etc/profile
然后按i进入编辑模式，在文件末尾添加下面的环境变量配置：
CATALINA_HOME=/usr/tomcat/apache-tomcat-7.0.86
export CATALINA_HOME  
然后ESC退出编辑模式，然后输入:wq保存退出
9.使环境变量立即生效
输入命令：source /etc/profile

检查linux是否安装tomcat
rpm -qa|grep tomcat

JAVA_HOME=/home/gcs/user/java/jdk1.8.0_111
PATH=$JAVA_HOME/bin:$PATH
CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export JAVA_HOME
export PATH
export CLASSPATH
这里的：表示分割符  . 表示当前路径；

JAVA_HOME=/usr/java/jdk-10.0.1
CLASSPATH=$JAVA_HOME/lib/
CATALINA_HOME=/usr/local/tomcat                     tomcat环境变量
PATH=$PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin
export PATH JAVA_HOME CLASSPATH CATALINA_HOME

usr/local/src/tomcat/apache-tomcat-7.0.92








Java基础：

httpclient资源：

testNG资源：

springboot资源：

spring资源：

mybaties资源：

RestTemplate资源：

jenkins资源：
1、下载地址
wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war
方法二：
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo  

sudo rpm --import http://pkg.jenkins-ci.org/redhat/jenkins-ci.org.key

yum install jenkins

输入启动命令以启动Jenkins服务。
service jenkins start

更改配置文件：
输入命令进入Jenkins配置文件
vi /etc/sysconfig/jenkins 





git资源：
查看git版本
git --version


