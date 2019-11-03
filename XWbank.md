#2019.6.25
1.dubbo微服务
2.git 使用
服务器上查看日志文件信息：
tail -f  test.log    (循环查看文件内容)  tail -f 日志文件
tail -200f  test.log  //查看日志文件倒数后200行日志；
如果在服务器上查看日志时，想快速定位需要搜索的内容，直接使用vi vim编辑器进入后，使用"/+需要搜索的内容"回车后
就能直接定位到那个内容出现的位置。



---------------------------------------------------------------------------------------------------------
post和get的区别：

如果出现域名解析不了时，应该在本机上找到hosts文件，在改文件添加相应的IP地址和DNS地址；

HashMap是无序的
Map<String, List<Integer>> listMap = new LinkedHashMap<String, List<Integer>>();//有序的
Map<Integer, String> map = new HashMap<Integer, String>();
         map.put(2, "b");
         map.put(3, "ab");
         map.put(4, "ab");
         map.put(1, "a");
         map.put(4, "ab");// 和上面相同 ， 会自己筛选
         System.out.println(map.size());
		 
LinkedHashMap 是有序的

	 
set 去重功能，存放的元素不可重复的。


StringUtils常使用的用法
---------------------------------------------------------------------------------------------------------  
StringUtils.isBlank(null) = true
      StringUtils.isBlank("") = true
      StringUtils.isBlank("  ") = true
      StringUtils.isBlank("        ") = true
      StringUtils.isBlank("\t \n \f \r") = true   //对于制表符、换行符、换页符和回车

      StringUtils.isBlank()=true  //均识为空白符

     StringUtils.isBlank("\") = false   //"\b"为单词边界

     StringUtils.isBlank("fff") = false

     StringUtils.isBlank("ffff ") = false

迭代器的用法
---------------------------------------------------------------------------------------------------------  
Collection coll1 = new ArrayList();
        coll1.add(132);
        coll1.add(456);
        coll1.add(789);
        Iterator iterator = coll1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
		
---------------------------------------------------------------------------------------------------------	
ConfMgr.class是获取ConfMgr的class对象，类型类指的是代表一个类型的类，因为一切皆是对象，几种获取class对象的方法：		
还可通过类的对象实例下的getClass()方法来获取Class对象，即 实例名getClass()

Str.trim()的用法除去空格等；
---------------------------------------------------------------------------------------------------------	
ArrayListy 有序 可重复
set         无序  不重复  （去重功能）


LinkedHashMap  有序  键值不可重复   value值可以重复
HashMap        无序  键值不可重复   value值可以重复

---------------------------------------------------------------------------------------------------------
SELECT - 从数据库表中获取数据

UPDATE - 更新数据库表中的数据

DELETE - 从数据库表中删除数据

INSERT INTO - 向数据库表中插入数据

CREATE DATABASE - 创建新数据库

ALTER DATABASE - 修改数据库

CREATE TABLE - 创建新表

ALTER TABLE - 变更（改变）数据库表

DROP TABLE - 删除表

CREATE INDEX - 创建索引（搜索键）

DROP INDEX - 删除索引

---------------------------------------------------------------------------------------------------------
beforesuite
beforeTest
beforeclass's TestNG2
TestNG2's beforemethod
TestNG2's testt1
TestNG2's aftermethod
TestNG2's beforemethod
TestNG2's testt2
TestNG2's aftermethod
afterclass's TestNG2
aftertest
aftersuite
---------------------------------------------------------------------------------------------------------
1.Integer转换成int的方法
Integer i;
int k = i.intValue();
即Integer.intValue();

2.int转换成Integer
int i;
Integer it = new Integer(i);

3.String转换成int的方法
String str = "10";
Integer it = new Interger(str);
int i = it.intValue();
即：int i = Integer.intValue(string);

4.int转换成String
int i;
(1)String s = String.valueOf(i);
(2)String s = Ingeger.toString(i);
(3)String s = "" + i;

5.String转换成Integer
String str = "10"
Integer it = Integer.valueOf(str);

6.Integer转换成String
Integer it;
String str = it.toString();

7.String转换成BigDecimal
BigDecimal bd = new BigDecimal(str);

8.日期
Calendar calendar = Calendar.getInstance();
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH)+1;
int day = calendar.get(Calendar.DATE);
//获取今天的日期字符串
String today = Java.text.DateFormat.getDateInstance().format(new java.util.Date());
//获取今天的日期
new java.sql.Date(System.currentTimeMillis());

---------------------------------------------------------------------------------------------------------
 String s = "xXccxxxXX";
	// 从头开始查找是否存在指定的字符         //结果如下 
	System.out.println(s.indexOf("c"));     //2      如果找到了该字符，则返回查找的字符的索引位置
	// 从第四个字符位置开始往后继续查找，包含当前位置
	System.out.println(s.indexOf("c", 3));  //3
	//若指定字符串中没有该字符则系统返回-1
	System.out.println(s.indexOf("y"));     //-1    如果没有找到该字符，则返回-1；
	System.out.println(s.lastIndexOf("x")); //6
		
---------------------------------------------------------------------------------------------------------	


关于token的技术文档：	
http://www.ruanyifeng.com/blog/2018/07/json_web_token-tutorial.html



--------------------------------------------------------------------------------------------------
fastjson对象，JSON，字符串，map之间的互转
1.对象与字符串之间的互转

将对象转换成为字符串
String str = JSON.toJSONString(infoDo);
字符串转换成为对象
InfoDo infoDo = JSON.parseObject(strInfoDo, InfoDo.class);


2.对象集合与字符串之间的互转

将对象集合转换成为字符串
String users = JSON.toJSONString(users);
将字符串转换成为对象集合
List<User> userList = JSON.parseArray(userStr, User.class);  

3.字符串互转JSONObject

String 转 Json对象
JSONObject jsonObject = JSONObject.parseObject(jsonString);
json对象转string
JSONObject jsonObject = JSONObject.parseObject(str);//json对象转字符串 
String jsonString = jsonObject.toJSONString();

4.map与字符串之间互转

 

  //字符串转map
  JSONObject  jsonObject = JSONObject.parseObject(str);
  Map<String,Object> map = (Map<String,Object>)jsonObject;//    //json对象转Map
  //map转字符串
  String jsonString = JSON.toJSONString(map);
5.Map 转 Json对象

复制代码
   //map转json对象
    Map<String,Object> map = new HashMap<>();
    map.put("age", 24);
    map.put("name", "cool_summer_moon");
    JSONObject json = new JSONObject(map);
　　//json对象转Map 
　　Map<String,Object> map = (Map<String,Object>)jsonObject; 
复制代码
6.map互转对象

 

7.json对象互转对象
		
---------------------------------------------------------------------------------------------------------
		
构造方法是只有你在new对象的时候才会执行,静态语句块和静态方法在类加载到内存的时候就已经执行了
,另外,静态语句块只能给静态变量赋值,里面不能出现方法,同样,静态方法里面也不能出现静态语句块

java中首先是静态块先执行，静态方法，最后是构造函数。

调用静态方法之前是不是先执行了静态语句块呢?
追答
对,先是静态语句块执行,然后静态方法加载到内存.
静态语句块你不管它它自动会执行,而静态方法它一直存在于内存中,只有你用类名点方法名的时候才会执行

public class ExA {  
    static {  
        System.out.println("父类--静态代码块");  
    }  
   
    public ExA() {  
        System.out.println("父类--构造函数");  
    }  
   
    {  
        System.out.println("父类--非静态代码块");  
    }  
   
    public static void main(String[] args) {  
        new ExB();  
    }  
}  
   
class ExB extends ExA {  
    static {  
        System.out.println("子类--静态代码块");  
    }  
    {  
        System.out.println("子类--非静态代码块");  
    }  
   
    public ExB() {  
        System.out.println("子类--构造函数");  
    }  
}  
 
执行结果 
===== 
父类--静态代码块 
子类--静态代码块 
父类--非静态代码块 
父类--构造函数 
子类--非静态代码块 
子类--构造函数
---------------------------------------------------------------------------------------------------------


 在Java中，可以将一个类定义在另一个类里面或者一个方法里边，这样的类称为内部类，广泛意义上的内部类一般包括四种：成员内部类，局部内部类，匿名内部类，静态内部类 。

1.成员内部类

    （1）该类像是外部类的一个成员，可以无条件的访问外部类的所有成员属性和成员方法（包括private成员和静态成员）；

    （2）成员内部类拥有与外部类同名的成员变量时，会发生隐藏现象，即默认情况下访问的是成员内部类中的成员。如果要访问外部类中的成员，需要以下形式访问：【外部类.this.成员变量  或  外部类.this.成员方法】；

    （3）在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问；

    （4）成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象；

    （5）内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。如果成员内部类用private修饰，则只能在外部类的内部访问；如果用public修饰，则任何地方都能访问；如果用protected修饰，则只能在同一个包下或者继承外部类的情况下访问；如果是默认访问权限，则只能在同一个包下访问。外部类只能被public和包访问两种权限修饰。

2.局部内部类

    （1）局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内；

    （2）局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的；

    （3）对于局部内部类，只有在方法的局部变量被标记为final或局部变量是effctively final的，内部类才能使用它们。

3.匿名内部类

    （1）一般使用匿名内部类来编写事件监听代码；

    （2）匿名内部类是不能有访问修饰符和static修饰符的；

    （3）匿名内部类是唯一一种没有构造器的类；

    （4）匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。

4.内部静态类

    （1）静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似；

    （2）不能使用外部类的非static成员变量或者方法。
 ———————————————— 
版权声明：本文为CSDN博主「夏沐_lk」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/guanmao4322/article/details/82820702

 在Java中，可以将一个类定义在另一个类里面或者一个方法里边，这样的类称为内部类，广泛意义上的内部类一般包括四种：成员内部类，局部内部类，匿名内部类，静态内部类 。

1.成员内部类

    （1）该类像是外部类的一个成员，可以无条件的访问外部类的所有成员属性和成员方法（包括private成员和静态成员）；

    （2）成员内部类拥有与外部类同名的成员变量时，会发生隐藏现象，即默认情况下访问的是成员内部类中的成员。如果要访问外部类中的成员，需要以下形式访问：【外部类.this.成员变量  或  外部类.this.成员方法】；

    （3）在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问；

    （4）成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象；

    （5）内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。如果成员内部类用private修饰，则只能在外部类的内部访问；如果用public修饰，则任何地方都能访问；如果用protected修饰，则只能在同一个包下或者继承外部类的情况下访问；如果是默认访问权限，则只能在同一个包下访问。外部类只能被public和包访问两种权限修饰。

2.局部内部类

    （1）局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内；

    （2）局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的；

    （3）对于局部内部类，只有在方法的局部变量被标记为final或局部变量是effctively final的，内部类才能使用它们。

3.匿名内部类

    （1）一般使用匿名内部类来编写事件监听代码；

    （2）匿名内部类是不能有访问修饰符和static修饰符的；

    （3）匿名内部类是唯一一种没有构造器的类；

    （4）匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。

4.内部静态类

    （1）静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似；

    （2）不能使用外部类的非static成员变量或者方法。
 

-----------------------------------------------------------------------------------------------------------------------------


		