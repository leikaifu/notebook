filesfist文件开头：

运用python中常见问题总结

1、Python读取ini文件需要用到 ConfigParser 模块
关于ConfigParser模块的介绍详情请参照官网解释：https://docs.python.org/2.7/library/configparser.html
2、要读取的ini文件（configfile.ini）如下：
以"[browserType ]"做section,browserName 为options
3.文件路径：./config/new.ini  这个路径里面的"./"其实是可以省略的。
"./"  表示当前文件夹
"../" 表示当前文件夹的上一级文件夹
相对路径

1.不可变数据类型与可变数据类型

数值型，字符串，bool都是不可变数据类型

list是可变数据类型：<有增删改查>并且是有顺序的。

数据类型含有：int,float,complex(复数)，str,list,bool

 

2.元组的英文tuple,定义元组：空元组，单个值元组，普通元组

元组创建很简单，只需要在括号中添加元素，并使用逗号隔开即可;

tuple = ("hello")      #字符串

print(type(tuple))

tuple1 = ("python",)    #单个值元组

print(type(tuple1))

tuple2 = ()           #空元组

print(type(tuple2))

tuple3 = (2,"hello",[1,2,3])   #普通元组

print(type(tuple3))

 

3.元组的索引

t = (1, 2, 3, "hello")

print(type(t))

输出结果：<class 'tuple'>

print(t[0])    #打印元组的第一个元素

输出结果：1

 

4.元组进行切片

print(t[1:])    #打印元组除第一个元素的其他元素

输出结果：(2, 3, 'hello')

print(t[:-1])   #打印元组除了最后一个元素的其他元素

输出结果：(1, 2, 3)

print(t[::-1])  #反转元素

输出结果：('hello', 3, 2, 1)

 

5.元组可以重复

t = (1, 2, 3, "hello")

print(t*3)   #重复出现三次

输出结果：(1, 2, 3, 'hello', 1, 2, 3, 'hello', 1, 2, 3, 'hello')

元组不能和其他字符串，列表进行连接，只能和元组进行连接

print(t+[5,6,7])

报错：TypeError: can only concatenate tuple (not "list") to tuple

print(t+(5,6,7))

输出结果：(1, 2, 3, 'hello', 5, 6, 7)

.如果想要将列表与元组连接，可以将列表强制转化为元组，然后在进行连接

print(t+tuple([5,6,7]))

输出结果：(1, 2, 3, 'hello', 5, 6, 7)

 

6，元组可以进行成员操作符；

print("hello" in t)

输出结果：True

print("hello" not in t)

输出结果：False

7.枚举：将字符串里面的元素与索引值一一对应；enumerate(专业术语：列举)

for index,item in enumerate(t):

   print(index,item)

输出结果：

0 1
1 2
2 3
3 hello

如果希望知道某元素在第几位，按顺序排列，给索引值加一

    print(index+1,item)

输出结果：

1 1
2 2
3 3
4 helllo

8, x, y = y, x的赋值过程

x = int(input("请输入x变量的值:"))

y = int(input("请输入y变量的值:"))

tuple = (y , x)

x = tuple[0]

y = tuple[1]

print("x,y的值分别为：%d,%d"%(x,y))

另外方法：

tuple = ("prthon" , "java")

print("hello %s, hello %s"%(tuple[0],tuple[1])) #下面公式可以分解为该公式；

print("hello %s, hello %s" %(tuple))

 

9.元组的赋值

tuple = ("xiaoming", 18, 50)

name, age, weight = tuple

print(name, age, weight)

输出结果：xiaoming 18 50

 

10.列表的赋值

list = ["xiaoming", 18, 50]     ###注意赋值只能一一对应，不能缺少也不能多处，否则会报错

name, age, weight = list

print(name, age, weight)

输出结果：xiaoming 18 50

11，元组中的元素是不允许修改的，可以将两个yuan元素合并为一个新的元素

t1 = (1,2,3,"hello")
t2 = ("xiaoming", 18, 50)
t3 = t1 + t2
print(t3)
输出结果：(1, 2, 3, 'hello', 'xiaoming', 18, 50)
12，删除元组

元组中的元素值是不允许删除的，但我们可以使用del语句来删除整个元组

t1 = (1,2,3,"hello")
t2 = ("xiaoming", 18, 50)
del t2
print(t1)
print(t2)

输出结果为：
(1, 2, 3, 'hello')
NameError: name 't2' is not defined

									python基础大纲
一、数据类型
1、数字
int（整型）
long（长整型）
float（浮点型）
complex（复数）
2、布尔值
　True或False
3、字符串
 
二、变量
变量命名规则：
变量名只能是 字母、数字或下划线的任意组合
变量名的第一个字符不能是数字
变量名不能为关键字（例如：and，or，continue，break，in，else，print 等）
 
三、字符串拼接
1、使用加号（+）
name = "Tom"
age = 25
print(name + "s age is " + str(age))

#输出：Toms age is 25  
2、字符串格式化

name = "Tom"
age = 25
print("%s's age is %d" % (name,age) )

#输出：Toms age is 25
 ps：在python中，使用+号连接字符串，每出现一个+号，就要重新在内存中申请一块空间，有多少个+号，就要申请多少块空间。一般不建设使用+号连接字符串。

 

四、列表和元组

1、列表（list）

创建列表
str_list = ['Tom','Lucy','Mary']
或者
str_list = list(['Tom','Lucy','Mary'])
 索引（访问列表中某一个值）
str_list[0]
追加（增加元素到末尾）
str_list.append('lilei')
print(str_list)

#输出：['Tom', 'Lucy', 'Mary', 'lilei']
插入（在指定位置加入元素）
str_list.insert(1,'lilei')
print(str_list)

#输出：['Tom', 'lilei', 'Lucy', 'Mary']
 删除（删除指定元素）
str_list.remove('Lucy')
print(str_list)

#输出：['Tom', 'Mary']
 切片
复制代码
str_list = [3,4,5,6,7,8,9]
new_1 = str_list[1:3]    #从索引1开始取，取到索引3
new_2 = str_list[0:6:2]  #从索引0开始取，每两位一取，到第6位为止
new_3 = str_list[-2:]    # 取后面2个数
new_4 = str_list[:3]     # 取前面3个数
new_5 = str_list[::3]    #所有数，每3个取一个

print(new_1,new_2,new_3,new_4,new_5)

#输出：[4, 5] [3, 5, 7] [8, 9] [3, 4, 5] [3, 6, 9]
复制代码
2、元组(tuple)

创建元组
age = (18,25,33)
或者
age = tuple((18,25,33))
 除了不能修改、增加、删除元素，其它操作元组和列表几乎一样。

 

 五、字典

使用key-value的存储方式

创建字典
phone = {
    '张三':'13075632152',
    '李四':'15732015632',
    '王五':'13420321523',
}
 获取字典中key的值
print(phone['张三'])      #如果key不存在，会报错，key用中括号装
print(phone.get('老黄'))  #如果key不存在，返回None,key用小括号装

#输出：13075632152
#     None 
 赋值
复制代码
phone['老黄'] = '13678623153'   #新增
phone['张三'] = '12300055555'   #修改
print(phone)

#输出：{'王五': '13420321523', '老黄': '13678623153', '张三': '12300055555', '李四': '15732015632'}
#因为字典是无序的，所以每次输出的排列顺序都可能不同
复制代码
 删除
phone.pop('张三')   #第一种方法
del phone['李四']   #第二种方法
phone.popitem()    #随机删除某一个
遍历
复制代码
for key in phone:
    print(key,phone[key])

#输出：
# 王五 13420321523
# 张三 13075632152
# 李四 15732015632
复制代码
多级嵌套
复制代码
phone = {
    '人事部':{'老张':'13700112233','老李':'13432023152'},
    '财务部':{'小丽':'13230555666','小映':'13723688888'},
    '技术部':{'老罗':'13866666333'}
}

print(phone['人事部']['老李'])

#输出：13432023152
复制代码
 

六、if语句

1、if...else

age = 16
if age <18:
    print('你还未成年呢')
else:
    print('你已经成年了')
2、if...elif....else

复制代码
score = 85
if score > 0 and score< 60:
    print('你的成绩不及格')
elif score >= 60 and score <80:
    print('你的成绩及格了')
elif score>=80 and score<90:
    print('你的成绩良好')
else:
    print('你的成绩优秀')
复制代码
 

七、while循环

i=0
num=0
while i<=100:
    num+=i
    i+=1
print('1-100累加等于%d'%num)
 

 八、for...in循环

num = []
for i in range(10):
    num.append(i)
print(num)

#输出：[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 

九、用户交互(input)

 

import getpass
username = input("username:")
password = getpass.getpass("password:")
print(username)
print(password)
 

 

 十、文件基本操作

 打开文件：f = open('文件路径'，'模式')    或者   with open('文件路径','模式') as f:

模式：

r：以只读方式打开文件
w：打开一个文件只用于写入。如果该文件已存在则将其覆盖。如果该文件不存在，创建新文件。
a：打开一个文件用于追加。如果该文件已存在，文件指针将会放在文件的结尾。也就是说，新的内容将会被写入到已有内容之后。如果该文件不存在，创建新文件进行写入。
w+：打开一个文件用于读写。(文件一打开就清空了，还能读到东西吗？)
a+：打开一个文件用于读写。
 读文件：

 read()  readlines()  readline() 的用法

复制代码
f = open('d:/test.txt','r')  #以只读方式打开文件

print(f.read())  #read()一次读取文件的全部内容

for line in f.readlines():   #readlines()读取整个文件，并按行存进列表
    print(line.strip('\n'))  #去掉行尾的'\n'

while 1:
    line = f.readline()   #readline()每次只读取一行
    print(line.strip('\n'))
    if not line:
        break

f.close()   #关闭文件
复制代码
写文件：

f =open('d:/test.txt','a')
f.write('hello,boy!\n')  
f.close()

如果使用with open('d:/test.txt','a') as fi:
fi.write('hello,boy!\n')
在python3 里面，这种形式的话就不用后面关闭文件了操作步骤了。


11、迭代器、可迭代对象、迭代器和生成器区别

12、装饰器


filesend文件结束
