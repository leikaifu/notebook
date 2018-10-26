
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