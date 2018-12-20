接口调用测试：Restlet Client 插件工具 ，安装在chrome上；

使用的编辑器：exlipse 、idea、STS

学习内容：
1、spring、springMVC、mybatis
2、jdbc连接数据库
3、springboot

学习日志：
时间：2018/10/16
完成的任务：
1、在idea编辑器上配置了junit4 
2、完成了第二课时spring视频学习
3、通过时视频资源，自己编程序实现视频里面讲解的知识点。
4、学习了git clone 下载地址

学习日志：
时间：2018/10/17
完成的任务：
1、aop注解的开发
    导入相关的jar包
    创建目标类
    创建切面类
    xml文件里面配置目标类、切面类、aop
2、解决了@RunWith(SpringJUnit4ClassRunner.class) 在编辑器idea里面不能加载成功显示红色提示。

3、expression常用方法
方法参数匹配
    args()
    @args()
方法描述匹配
    execution()
当前AOP代理对象类型匹配
    this()
目标类匹配
    target()
    @target()
    within()
    @within()
标有此注解的方法匹配
    @annotation()
其中execution 是用的最多的,其格式为:
    execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?) 
    returning type pattern,name pattern, and parameters pattern是必须的. 
    ret-type-pattern:可以为*表示任何返回值,全路径的类名等. 
    name-pattern:指定方法名, *代表所有 
    set*代表以set开头的所有方法. 
    parameters pattern:指定方法参数(声明的类型),(..)代表所有参数,(*)代表一个参数 
    (*,String)代表第一个参数为任何值,第二个为String类型.

举例说明：
任意公共方法的执行：

    execution(public * *(..))
    任何一个以“set”开始的方法的执行：
    execution(* set*(..))
    AccountService 接口的任意方法的执行：
    execution(* com.xyz.service.AccountService.*(..))
    定义在service包里的任意方法的执行：
    execution(* com.xyz.service.*.*(..))
    定义在service包和所有子包里的任意类的任意方法的执行：
    execution(* com.xyz.service..*.*(..))
    定义在pointcutexp包和所有子包里的JoinPointObjP2类的任意方法的执行：
    execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")
    ***> 最靠近(..)的为方法名,靠近.*(..))的为类名或者接口名,如上例的JoinPointObjP2.*(..))
    必记：在execution 语法中：在*号后面必须有一个空格；
    pointcutexp包里的任意类.
    within(com.test.spring.aop.pointcutexp.*)
    pointcutexp包和所有子包里的任意类.
    within(com.test.spring.aop.pointcutexp..*)
    实现了MyInterface接口的所有类,如果MyInterface不是接口,限定MyInterface单个类.
    this(com.test.spring.aop.pointcutexp.MyInterface)
    ***> 当一个实现了接口的类被AOP的时候,用getBean方法必须cast为接口类型,不能为该类的类型.

    带有@MyTypeAnnotation标注的所有类的任意方法.
    @within(com.elong.annotation.MyTypeAnnotation)
    @target(com.elong.annotation.MyTypeAnnotation)
    带有@MyTypeAnnotation标注的任意方法.
    @annotation(com.elong.annotation.MyTypeAnnotation)
    ***> @within和@target针对类的注解,@annotation是针对方法的注解

    参数带有@MyMethodAnnotation标注的方法.
    @args(com.elong.annotation.MyMethodAnnotation)
    参数为String类型(运行是决定)的方法.
    args(String)


2018/10/17
学习日志：
1、 在A文件中导入B文件即可：
    在A配置文件中引入B配置文件
    <import resource="B.xml"/>
2、在execution 语法中：在*号后面必须有一个空格；
例如：execution(* com.xyz.service.AccountService.*(..))；

3、把aop切面编程开发调试通过了；
4、设置utf-8编码格式：
（1）File菜单->Other Settings->Default Settings
（2）找到File Encodings，把IDE Encoding和Project Encoing的下拉框都设置为UTF-8，最底下还有一个default encoding for properties(这是设置属性文件)也设置成utf-8

学习日志：
时间：2018/10/20
完成的任务：
1、推荐软件印象笔记
2、百度网盘
3、github

笔记
git add -A 
git commit -m '提交信息'
git push 
输入账号
密码
提交成功OK
git push  发布
git pull  从上往本地拉文件
git电子课本

2018/10/20
学习日志：
1、springMVC-web-00
2、springMVC-web-01

                                       Eclipse常用快捷键
1几个最重要的快捷键

代码助手:Ctrl+Space（简体中文操作系统是Alt+/）
快速修正：Ctrl+1
单词补全：Alt+/
打开外部Java文档：Shift+F2

显示搜索对话框：Ctrl+H
快速Outline：Ctrl+O
打开资源：Ctrl+Shift+R
打开类型：Ctrl+Shift+T
显示重构菜单：Alt+Shift+T

上一个/下一个光标的位置：Alt+Left/Right 
上一个/下一个成员（成员对象或成员函数）：Ctrl+Shift+Up/Down
选中闭合元素：Alt+Shift+Up/Down/Left/Right
删除行：Ctrl+D
在当前行上插入一行：Ctrl+Shift+Enter
在当前行下插入一行： Shift+Enter
上下移动选中的行：Alt+Up/Down


组织导入：Ctrl+Shift+O


2 定位 
2.1行内定位 
行末/行首：End/Home
前一个/后一个单词：Ctrl+Right/Left
2.2文件内定位 
跳到某行：Ctrl+L
上下滚屏：Ctrl+Up/Down
上一个/下一个成员（成员对象或成员函数）：Ctrl+Shift+Up/Down
快速Outline：Ctrl+O 
2.3跨文件定位 
打开声明：F3
打开资源：Ctrl+Shift+R
打开类型：Ctrl+Shift+T
在workspace中搜索选中元素的声明：Ctrl+G
在workspace中搜索选中的文本：Ctrl+Alt+G
在workspace中搜索选中元素的引用：Ctrl+Shift+G
打开调用层次结构：Ctrl+Alt+H
快速层次结构：Ctrl+T
反悔：Ctrl+Z
2.4其它 
上一个/下一个光标所在位置：Alt+Left/Right
上一个编辑的位置：Ctrl+Q 

 

3 选中 
3.1行内选中 
选中到行末/行首：Shift+End/Home
选中上一个/下一个单词：Ctrl+Shift+Left/Right
3.2文件内选中 
选中闭合元素：Alt+Shift+Up
恢复到上一个选中：Alt+Shift+Down
选中下一个/上一个元素：Alt+Shift+Right/Left 

 

4 定位/选中/操作同时 
删除行：Ctrl+D
删除下一个/上一个单词：Ctrl+Delete/Backspace
删除到行末：Ctrl+Shift+Delete
在当前行上插入一行：Ctrl+Shift+Enter  
在当前行下插入一行： Shift+Enter
上下移动选中的行：Alt+Up/Down
拷贝选中的行：Ctrl+Alt+Up/Down 

 

5其它的代码编辑类快捷键 
保存：Ctrl+S
保存所有：Ctrl+Shift+S
下一个命中的项（搜索之后）：Ctrl+.
注释：Ctrl+/
添加导入：Ctrl+Shift+M
显示快捷键帮助：Ctrl+Shift+L
变为大/小写：Ctrl+Shift+X/Y

 

6 重构 
显示重构菜单：Alt+Shift+T
重构-改变方法签名：Alt+Shift+C
重构-移动：Alt+Shift+V
重构-重命名：Alt+Shift+R 

 

7 编辑器、视图、透视图切换 
下一个编辑器：Ctrl+F6
下一个视图：Ctrl+F7
下一个透视图：Ctrl+F8
最大化当前视图或编辑器：Ctrl+M
激活编辑器：F12 

 

8 Debug 
F5：Step Into（debug）
F6：Step over（debug）
F7：Step return（debug）
F8：Resume（debug）
F11：debug上一个应用（debug） 

 

9 Up/Down/Right/Left类快捷键 
Ctrl
前一个/后一个单词：Ctrl+Right/Left
上下滚屏：Ctrl+Up/Down
Alt
上一个/下一个光标的位置：Alt+Left/Right
上下移动选中的行：Alt+Up/Down
Shift
选中上一个/下一个字符：Shift+Left/Right
选中上一行/下一行（从当前光标位置开始）：Shift+Up/Down
Ctrl+Shift
上一个/下一个成员（成员对象或成员函数）：Ctrl+Shift+Up/Down
选中上一个/下一个单词：Ctrl+Shift+Left/Right
Alt+Shift
选中闭合元素：Alt+Shift+Up
恢复到上一个选中：Alt+Shift+Down
选中下一个/上一个元素：Alt+Shift+Right/Left
拷贝选中的行：Ctrl+Alt+Up/Down
Ctrl+Alt
拷贝选中的行：Ctrl+Alt+Up/Down 

 

10 F类快捷键 
F2：显示提示/重命名
F3：打开选中元素的声明
F4：打开选中元素的类型继承结构
F5：刷新
F5：Step Into（debug）
F6：Step over（debug）
F7：Step return（debug）
F8：Resume（debug）
F11：debug上一个应用（debug）
F12：激活编辑器

配置注解驱动
<mvc:annotation-driven />
配置处理映射器
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
配置处理器适配器
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>
配置注解驱动，相当于同时使用最新处理器映射跟处理器适配器,对json数据响应提供支持

配置视图解析器
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">

1、注解驱动         <mvc:annotation-driven />
2、处理映射器       RequestMappingHandlerMapping
3、处理器适配器     RequestMappingHandlerAdapter
4、视图解析器       InternalResourceViewResolver

5个默认的参数传递：
Modle 、ModleMapp  （这两个都是返回数据模型的）
、HttpServletRequest 、  HttpServletResponse 、 HttpSession


@RequestParam(value = "id",required = true,defaultValue = 1)
value是参数值  required等于true时就是说明这个参数必须填写  defaultValue就是给这个参数设定一个默认值


2018/10/22
学习日志：
1、总结了MySQL语句

2018/10/24
学习日志：
1、构造方法：
首先子类中的方法必须调用父类的构造方法，如果父类中只有一个有参的构造方法，你在子类的构造方法必须调用，而且是子类的构造方法第一句话必须是调用父类的有参构造方法，否则编译器会提示错误的。如果父类中有无参的构造方法，你没有写的话会自动调用的

2018/10/25
学习日志：
1、什么叫做匿名类？
2、advisor 是一个切入点和一个通知组；
   aspect 是支持多个切入点和多个通知组；
   <txt:method name="*" propagation="REQUIRED" timeout="-1" read-only="true" isolation="DEFAULT" no-rollback-for="" rollback-for=""   />

timeout="-1" 表示事务永久生效
isolation="DEFAULT  表示隔离为默认值

 <!--配置事务的增强====-->
    <txt:advice id="txtAdvice" transaction-manager="transactionManager">
        <txt:attributes>
            <txt:method name="save*" propagation="REQUIRED" isolation="DEFAULT"/>
            <txt:method name="update*" propagation="REQUIRED"/>
            <txt:method name="delete*" propagation="REQUIRED"/>
            <txt:method name="find*" read-only="true"/>
            <txt:method name="*" propagation="REQUIRED" />
        </txt:attributes>
    </txt:advice>
    <!--aop配置-->
    <aop:config>
        <!--切入点-->
        <aop:pointcut id="pointcut1" expression="execution(* com.itheima.AccountServiceImpl.*(..))"/>
        <!--切面通知-->
        <aop:advisor advice-ref="txtAdvice" pointcut-ref="pointcut1"/>
    </aop:config>

3、
（JAVA+TESTNG 三）Eclipse+TestNG搭建接口自动化测试框架
4、
请求转发
forward:
redirect:

提交乱码问题：
post 通过配置过滤器来解决
get  通过常用的在Tomcat设置上URIEncoding=utf-8

响应出现乱码问题：
response出现乱码问题：在获取getwriter之前，设置一个response.setCharacterEncoding("utf-8") 

异常：
编译异常
运行异常

springmvc 中有一个异常处理器；

2018/10/28
学习日志：
List和Set区别

1、List,Set都是继承自Collection接口
2、List特点：元素有放入顺序，元素可重复 ，
   Set特点：元素无放入顺序，元素不可重复（注意：元素虽然无放入顺序，但是元素在set中的位置是有该元素的HashCode决定的，其位置其实是固定的） 
3、List接口有三个实现类：LinkedList，ArrayList，Vector ，Set接口有两个实现类：HashSet(底层由HashMap实现)，LinkedHashSet


4、在dos下，输入  

    (1)：netstat   -ano|findstr  8080
//说明：查看占用8080端口的进程

    (2):taskkill  /pid  2140  /f  
//这里的2140是通过命令netstat   -ano|findstr  8080查到的ID号

//说明，运行windows自带taskkill命令，将上面显示的进程号，结束掉。

2018/10/31
学习日志：
第一个参数是要设置的 SQL 语句中的参数的索引(从 1 开始)，第二个是设置的 SQL 语句中的参数的值。
根据问号位置的参数类型来定的，如果第一个是int型的就是ps.setInt(1,num)；如果是String类型就是ps.setString(2,string)，以此类推


2018/11/1
学习日志：
1、Account a=new Account();
Account.class//很多地方这样写（其实就是一个对象）相当于 Account a=new Account();

Account a=Account.class.newInstance(); //这就是底层的写法，就是把传过来的Account.class  new 一个对象


2018/11/6
学习日志：
1、我们假设有一个接口A ，和它得实现类B，简化代码如下：

interface A { //接口A               
 //接口的方法声明必须是 public abstract ，即便不写默认也是public abstract
    public void fun();

}
public class B implements A {

    @Override
    public void fun() {
        //your coding
    }

}


2018/11/8
学习日志：
应为static的属性或方法是存放在栈里面的，它们属于类的信息，不需要new对象就可以直接使用，它们属于类，而不是属于某个new出来的对象，所以可以只接用类名加点号就可以引用，而一般的动态属性是属于某个对象的，它们是放在堆里的，所以要new出某个类的对象才能引用。

2018/11/12
学习日志：
使用到的工具是：Eclipse + TestNG + Maven + ReportNG

在IDEA控制台Terminal输入
mvn -f pom.xml clean test  -DxmlFileName=testNG.xml

testng 按组测试
配置文件

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite1">
    <test name="test1">
        <groups>
        <run>
        <include name="functiontest" />
        </run>
    </groups>
    </test>
</suite>


2018/11/16
学习日志：
filename.zip的解压命名：unzip filename.zip

filename.tar.gz的解压命令： tar -zxvf filename.tar.gz

z: gizp                      压缩格式
x: extract                   解压
v:verbose                    详细信息
f:file（file=archieve)        文件

下载命名 wget  http--------

服务器 server
1、查看服务器安装的版本
cat /etc/redha*

2、服务器网卡配置两种模式：

（1）服务器配置网卡（配置固定IP地址）
    DEVICE=eth0
    BOOTPROTO=static
    IPADDR=192.168.1.116
    NETMASK=255.255.255.0
    GATEWAY=192.168.1.1
    ONBOOT=yes
    DNS1=114.114.114.114  #填写网管的DNS地址

`（2）服务器配置网卡（自动获取IP地址）
    DEVICE=eth0
    BOOTPROTO=dhcp
    ONBOOT=yes

3、修改网卡后必须重启网卡
命令：
（1）/etc/init.d/network restart
（2）service network restart

4、检查网络是否正常---网卡重启成功后
（1）ping www.baidu.com  -t   #这样的写法是持续ping
（2）ping www.baidu.com       #这样的写法只能ping 4个包 就断连接

5、检测服务器是否获取到网关地址命名
route  -n   回车
 ping 网关地址    --就是ping 本地

6、编辑文本
i --是进入编辑状态；
:q  --退出，但是不保存；
:q! 强制退出并忽略所有更改
:wq  --退出并保存；

7、ifconfig 命令可以查看是那个网卡
一般默认网卡eth0 
            eth1
            eth2

8、设置网卡
vi /etc/sysconfig/network-scripts/ifcfg-eth0 或者
vim  /etc/sysconfig/network-scripts/ifcfg-eth0 

公司常用的:
查看服务器环境
echo $FOR_DOMAIN 

9、修改服务器登录密码
如果你可以以root身份登录的话就passwd命令就可以直接修改了
密码输入两次就OK了。

10、创建文件
命令：mkdir 文件名   

删除文件：
命令：rm -rf 文件名或者目录

例子：然后使用mkdir tomcat命令在local目录下创建一个tomcat目录。
11、
需要上传或者下载，需要使用rz和sz命令。如果linux上没有这两个命令工具，则需要先安装。可以使用yum安装。运行命令yum install lrzsz。 

yum -y install wget

less
more 其实有了less命令基本上可以抛弃more命令，less具有搜索功能，如果只是简单查看那就用more命令应该不需要跟任何参数，比较方便
./:表示当前目录
cat 
clear 清空所以界面

查看防火墙状态的命令：service iptables status
关闭防火墙的命令：service iptables stop

配置环境变量
编辑profile文件：vi /etc/profile

配置服务器环境：

linu系统安装vim   
1、下载vim安装包：wget ftp://ftp.vim.org/pub/vim/extra/vim-7.2-lang.tar.gz  解压 tar -zxvf vim包
2、yum install vim 
linu系统安装jdk配置环境变量
1、vim /etc/profile
2、编辑变量名
3、source /etc/profile  使用此命令运行后，就已经生效了。

Linux系统下安装jdk文档地址：https://www.cnblogs.com/manong--/p/8016884.html



自己在本地创库：
路径：C:\Users\lkf\.m2\repository
在repository的根目录下创建文件夹
1、首先创建一个文件夹123456    //123456是文件名
2、上面的文件夹里面再次创建一个文件夹123456    //123456是文件名
3、上面文件夹里面再次创建一个版本号比如  1.0 的文件夹   //1.0文件夹名
4、在1.0文件夹里面新建一个xx.pom文件，已经下载好的jar；
5、修改pom文件名为123456-1.0；修改jar的名称为123456-1.0；
6、在pom文件里面添加内容如下：
<project> 
  <modelVersion>1.0.0</modelVersion> 
  <groupId>123456</groupId> 
  <artifactId>123456</artifactId> 
  <version>1.0</version> 
</project> 



2018/11/22
学习日志：
1、Java读取excle表使用的jar包时jxl.jar poi.jar
java 整型类有两种  Integer int
（行，列）
HttpClient:
使用UrlEncodedFormEntity(nvps,Consts.UTF_8)
idea 编辑器：
快捷键ctrl+q  （查看调用方法时返回值的类型）
查找接口的实现类：ctrl + alt +B
查看类或接口的继承关系：ctrl + h
自动补全返回值，自动补全变量名称和属性名称：ctrl+alt+v
Ctrl+Shift+上下键 上下移动代码

java 中的instanceof 
1、是一个二元操作符（运算符）运算符，由于是字母组成，所以是Java的保留关键字，但是和>=，<=，==属同一类，它的作用是用来判断，instanceof 左边对象是否为instanceof 右边类的实例，返回一个boolean类型值。

2、还可以用来判断子父类的所属关系。
用法： 
boolean result = object instanceof class 
参数： 
Result：布尔类型。 
Object：必选项。任意对象表达式。 
Class：必选项。任意已定义的对象类。 
fastjson.jar API:https://blog.csdn.net/weixin_36413887/article/details/80497104
http——StringEntity 和 UrlEncodedFormEntity 的区别

数组-转换-List
第一种方法：
String[] userid = {"aa","bb","cc"};
List<String> userList = new ArrayList<String>();
Collections.addAll(userList, userid);
第二种方法：
String[] userid = {"aa","bb","cc"};
List<String> userList = Arrays.asList(userid);


2018/11/23
学习日志：
1、jsonschema校验接口返回的数据结构类型
dojo功能
DOJO已提供了JSON Schema来验证接口数据的功能
jsonschema2pojo

fastjson.jar 使用api文档：
1. 实体类或集合 转JSON串

String jsonString = JSONObject.toJSONString(实体类);
2.JSON串转JSONObject

JSONObject jsonObject = JSONObject.parseObject(jsonString);

3.JSON串转实体类

实体类 javaBean = JSON.parseObject(json, 实体类.class);
例子：
List<User> userList = JSON.parseArray(userStr, User.class);

4.JSON串转带泛型的List的集合

List<实体类或其他泛型> list = JSON.parseObject(json, new TypeReference<List<实体类或其他泛型>>(){});

        /***
         * 解析JSONObject字符串为制定的JavaBean；
         */
        User user = JSONObject.parseObject(JSON_OBJ_STR, User.class);

        /***
         * 将User用户转化成JSONObject对象
         * 将javabean转化成json字符串
         */
        User userJson = new User();
        userJson.setName("222");
        userJson.setAge(11);
        String jsonStr = JSON.toJSONString(userJson);
        System.out.println("---"+jsonStr);


Java中indexOf的用法
indexOf有四种用法：
1.indexOf(int ch) 在给定字符串中查找字符(ASCII),找到返回字符数组所对应的下标找不到返回-1

2.indexOf(String str)在给定符串中查找另一个字符串第一次出现的位置。。。

3.indexOf(int ch,int fromIndex)从指定的下标开始查找某个字符，查找到返回下标，查找不到返回-1

4.indexOf(String str,int fromIndex)从指定的下标开始查找某个字符串。。。
public static void main(String[] args) {
        char[] ch= {'a','b','c','h','e','l','l','o'};
        String str=new String(ch);

 
        //1.indexOf(int ch)
        str.indexOf(104);
        System.out.println(str.indexOf(104));//h所在下标为3
 
        //2.indexOf(String str)
        str.indexOf("hell");
        System.out.println(str.indexOf("hell"));//3
 
        //3.indexOf(int ch,int fromIndex)
        str.indexOf(101, 4);//4
        System.out.println(str.indexOf(101, 4));
        str.indexOf(101,5);//没有查找到返回-1
        System.out.println(str.indexOf(101,5));
 
        //4.indexOf(String str,int fromIndex)
        str.indexOf("che", 0);//等价于str.indexOf("che")
        System.out.println(str.indexOf("che", 0));//2
    }

Java中字符串中子串的查找共有四种方法，如下：
1、int indexOf(String str) ：返回第一次出现的指定子字符串在此字符串中的索引。 
2、int indexOf(String str, int startIndex)：从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。 
3、int lastIndexOf(String str) ：返回在此字符串中最右边出现的指定子字符串的索引。 
4、int lastIndexOf(String str, int startIndex) 

public class Test {
    public static void main(String[] args) {
        String s = "xXccxxxXX";
        // 从头开始查找是否存在指定的字符         //结果如下 
        System.out.println(s.indexOf("c"));     //2
        // 从第四个字符位置开始往后继续查找，包含当前位置
        System.out.println(s.indexOf("c", 3));  //3
        //若指定字符串中没有该字符则系统返回-1
        System.out.println(s.indexOf("y"));     //-1
        System.out.println(s.lastIndexOf("x")); //6
    }
}

分析一下if  ifelse 
学习正则表达式
a.getClass()分析这样写是什么意思。

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "ab");
        map.put(4, "ab");
        map.put(4, "ab");// 和上面相同 ， 会自己筛选
        System.out.println(map.size());
        // 第一种：
        /*
         * Set<Integer> set = map.keySet(); //得到所有key的集合
         * 
         * for (Integer in : set) { String str = map.get(in);
         * System.out.println(in + "     " + str); }
         */
        System.out.println("第一种：通过Map.keySet遍历key和value：");
        for (Integer in : map.keySet()) {
            //map.keySet()返回的是所有key的值
            String str = map.get(in);//得到每个key多对用value的值
            System.out.println(in + "     " + str);
        }
        // 第二种：
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
             Map.Entry<Integer, String> entry = it.next();
               System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        // 第三种：推荐，尤其是容量大时
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }
        // 第四种：
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}

bufferedReader()的
1、readline(）方法不可以直接读到文件末尾，可以自己封装一个读取到文件末尾的函数。
如果读到最后一行后，返回的值为“-1”

2、readLine()方法读出是null，就表示文件结尾了。
这么写，可以一直读到文件结尾：
读取txt文件的内容
 public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }

Class theClass="hello".getClass();//获得当前对象的类型...java中有Class类,用以描述类型信息.
json 数据类型：
数字（整数或浮点数）number
字符串（在双引号中）String
逻辑值（true 或 false） boolean
数组（在中括号中） Array
对象（在大括号中） Object
null              null

通常我们校验接口有这样几种:
1.判断字段值与预期是否相等
2.判断是否包含某字段
3.判断数据数量是否正确
4.判断数据格式

java map的key可以重复吗？
不可以，map是无序的，它的查询需要通过key的值来查找，如果你定义两个同样的key,那么一个key就对应了多个值，这样就违背了java对map的定义，键和值是一一对应的。所以key不可以重复；
 //注意：map中key值不可重复，直接根据比较的是equals,只有equals相同则覆盖
HashMap是不会按顺序存储的。
LinkedHashMap可以保证按put()调用的先后顺序进行存储，LinkedHashMap应该满足你的需求。

2018/11/26
学习日志：
gerrit?学习一下+genkis
StringUtils里的isEmpty方法和isBlank方法的区别
1、public static boolean isEmpty(String str) {        return str == null || str.length() == 0;}

2、public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {    //判断字符是否为空格、制表符、tab
                    return false;
                }
            }
 
            return true;
        } else {
            return true;
        }
    }
通过以上代码我们可以看出：
    1.isEmpty没有忽略空格参数，是以是否为空和是否存在为判断依据。
    2.isBlank是在isEmpty的基础上进行了为空的判断。（一般更为常用）
StringUtils.isEmpty("yyy") = false
StringUtils.isEmpty("") = true
StringUtils.isEmpty("   ") = false
 
StringUtils.isBlank("yyy") = false
StringUtils.isBlank("") = true
StringUtils.isBlank("   ") = true

java工具类系列 （一.StringUtils）
查询地址：https://blog.csdn.net/lxzo123/article/details/6789343

if 和else用法：
if else是条件分支语句

1、if else只判断一次
if(5>6){
//如果5是大于6的话就执行这里
}else{
//如果5不大于6的话就执行这里
}

2、if else if else执行2次判断
if(5>6){
//如果5是大于6的话就执行这里
}else if(5==6){
//如果5不大于6并且5等于6的话就执行这里
}else{
//上面2个条件都不满足就执行这里
}

判断：
str.startWith(）方法
同理startends(）方法相反
判断字符串是否以某个子字符串开头。
比如字符串“abcdefg”.startWith("abc") 判断结果是true，因为它是以 abc 开头的。

2018/11/28
学习日志：
java 中this的用法
new只出现在调用构造方法之前用来生成对象
即：Student a = new Student();
this的用法：
1、当全局变量跟局部变量重名时，表示使用全局变量（此时this指代本类对象）
例：
有一类
class A{
    String name;
    void setName(String name){
        this.name = name;
    }
}
2、构造方法相互调用，此时this指代本类类名
注意this只能放在构造方法第一句
如
class B{
       String name;
       B(){
       this("name");//会自动调用带String参数的构造方法
    }
    B(String name){
        this.name = name;
    }
}
先说new，new就是创建个对象，比如你有个类A，如果想使用他，就需要  A a=new A();
再说return，这个使用在方法里的，遇到return就是方法结束了，不过不是所有的方法里都需
要return，使用return一般有两种环境：1是方法有返回值，如 public String aa()
{ return "aaa";}，2就是方法不需要返回值也可以使用return ,如public void aa(){
 return;}第二种情况一般用在循环里面
 
this说的不好理解；
this就是说这个类的当前这个对象，也就是构造方法产生的对象。
你new对象或者调用方法时，当碰到有this时，this就代表他自己。
另外，涉及到静态的东西，就不会用this，因为静态的东西是一个类所有对象共用的东西，
不归某一个对象；
所以你可以在eclipse中编码时看到，静态方法你用this.staticMethod()会报警告，因为静
态方法不归这个对象，归这个类的所有实例对象。
https://blog.csdn.net/HD243608836/article/details/80827522s

服务器部署：http://www.mamicode.com/info-detail-1336922.html

2018/11/29
学习日志：
StringBuilder的常用方法
在程序开发过程中，我们常常碰到字符串连接的情况，方便和直接的方式是通过"+"符号来实现，但是这种方式达到目的的效率比较低，且每执行一次都会创建一个String对象，即耗时，又浪费空间。使用StringBuilder类就可以避免这种问题的发生，下面就Stringbuilder的使用做个简要的总结：
一、创建Stringbuilder对象
StringBuilder strB = new StringBuilder();

1、append(String str)/append(Char c)：字符串连接
System.out.println("StringBuilder:"+strB.append("ch").append("111").append('c'));
//return "StringBuilder:ch111c"

2、toString()：返回一个与构建起或缓冲器内容相同的字符串
System.out.println("String:"+strB.toString());
//return "String:ch111c"

3、appendcodePoint(int cp)：追加一个代码点，并将其转换为一个或两个代码单元并返回this
System.out.println("StringBuilder.appendCodePoint:"+strB.appendCodePoint(2));
//return "StringBuilder.appendCodePoint:ch111c"

4、setCharAt(int i, char c)：将第 i 个代码单元设置为 c（可以理解为替换）
strB.setCharAt(2, 'd');
System.out.println("StringBuilder.setCharAt:" + strB);
//return "StringBuilder.setCharAt:chd11c"

5、insert(int offset, String str)/insert(int offset, Char c)：在指定位置之前插入字符(串)
System.out.println("StringBuilder.insertString:"+ strB.insert(2, "LS"));
//return "StringBuilder.insertString:chLSd11c"
System.out.println("StringBuilder.insertChar:"+ strB.insert(2, 'L'));
//return "StringBuilder.insertChar:chLLSd11c"

6、delete(int startIndex,int endIndex)：删除起始位置（含）到结尾位置（不含）之间的字符串
System.out.println("StringBuilder.delete:"+ strB.delete(2, 4));
//return "StringBuilder.delete:chSd11c"

2018/12/3
学习日志：
读取配置文件：
ResourceBundle bundle=ResourceBundle.getBundle("application");
String url=bundle.getString("test.url");

2018/12/6
学习日志：
getAbsoluteFile()返回的是一个File类对象，这个File对象表示是当前File对象的绝对路径名形式
getAbsolutePath()返回的是一个字符串，这个字符串就是当前File对象的绝对路径名的字符串形式


 poi导入excel表格数据时报java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell异常是因为在读取cell单元格字符串时，有number类型的数据，因此需要把它转化为纯String类型，这样就不会报错了。
报错的地方类似于这样。
 //获取单元格
XSSFCell cell = row.getCell(0);
//获取单元格数据
String cellValue = cell.getStringCellValue();

在number类型转化为String类型的过程中造成了Cannot get a STRING value from a NUMERIC cell这样的问题，因此需要在读取excel单元格数据转化之前设置单元格类型为String，代码如下。
//获取单元格
XSSFCell cell = row.getCell(0);
//设置单元格类型
cell.setCellType(CellType.STRING);
//获取单元格数据
String cellValue = cell.getStringCellValue();

2018/12/7
学习日志：
public void testMap(){            
        Map map = new HashMap();
        map.put(1, "aa");   
        map.put(2, "aac");
        map.put(3, "aacc");
        map.put(4, "aa4");
        9//map.put(1, "aat"); //key 不能够重复 如果Key值重复 则下一个值会覆盖上一个值
     //1、迭代map集合的值
     Set set = map.keySet(); //key装到set中
     Iterator it = set.iterator(); //返回set的迭代器 装的key值
     while(it.hasNext()){
     Integer key = (Integer)it.next();
     String value = (String)map.get(key);
     System.out.println(key+" "+value);
     }
     //2、迭代map集合的值
     Set entry = map.entrySet(); //Set <Map.entry<K,V>>
     it = entry.iterator(); //返回set的迭代器 装Map.entry
     while(it.hasNext()){ //迭代
     Map.Entry entity = (Entry) it.next(); //实体Map.entry的对象取出
     Integer key = (Integer)entity.getKey(); //调用实体对象的getKey()获取key的值      
     String value = (String)entity.getValue(); //调用实体对象的getValue()获取value的值
     System.out.println(key+" "+value);
     //如何用for循环输出Map的值 如下：
System.out.println("-------------------------");
for(Object ob:map.keySet()){
System.out.println(ob+" "+map.get(ob));  
}
System.out.println("####################33");
for(Map.Entry<Integer, String> m:map.entrySet()){
System.out.println(m.getValue()+" "+m.getKey());
}
}


2018/12/13
学习日志：

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


    http请求
    resttemplate，httpclient,okhttpclient.


2018/12/14
学习日志：
错误：Cannot find /usr/local/tomcat/bin/setclasspath.sh
执行语句：unset CATALINA_HOME  
即可解决错误


2018/12/19
学习日志：
ls -al 查看所有文件包括隐藏文件。
nohup java -jar jenkins.war --httpPort=8080  nohup就是利用后台的方式启动的。
tial -f 日志文件名  查看日志命令
修改简历！！！！
