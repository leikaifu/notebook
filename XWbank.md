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
		
		
		
		
		
		