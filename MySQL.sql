                    数据库

1、查看数据库
show databases； 查看所以存在的数据库名
2、创建数据库
create database mybatis;   mybatis就是取的数据库名
3、删除数据库
drop database mybatis; 

                    数据表
DDL数据库定义
1、创建表
create table book（
    id int unsigned not null auto_increment primary key,
    userName varchar(20) not null,
    address varchar(20) not null,
    sex     varchar(20) not null);
2、表重命名
rename table book to user2;  把book修改为user2；

3、删除表
drop table book;

4、字段管理:
    1.添加字段--user是表名
    alter table user add age tinyint unsigned not null;
    alter table user add pass varchar(30) not null after username;
    alter table user add pass varchar(30) not null first;

    2.删除字段--password是字段名
    alter table user drop password;

    3.修改字段
    alter table user modify username varchar(30) not null;
    alter table user change username user varchar(30) not null;

    4.查看字段
    desc user;
DML数据库操作语言
字段对应内容：

4.增-insert:
insert into user(username,password) values('user1','123');

5.删-delete:
delete from user where id=5;

6.改-update:
update user set password='123' where id=2;
update user set username='user33',password='123' where id=3;

DQL 数据库查询语言
7.查-select:
select * from user;
#查询表中所有字段以及每个字段所对应的所有记录
#
#
DCL 数据控制语言


8.where条件
1)where id>=3 and id<=7
where id between 3 and 7;

2)where id=3 or id=5 or id=7;
where id in(3,5,7);





索引:
1.主键
1)添加
mysql> create table user2(
    -> id int unsigned not null auto_increment,
    -> username varchar(30) not null,
    -> primary key(id)
    -> );

mysql> create table user2(
    -> id int unsigned not null auto_increment primary key,
    -> username varchar(30) not null
    -> );

2)删除
alter table user2 modify id int unsigned not null;
alter table user2 drop primary key;

2.唯一
1)添加
alter table user2 add unique u_username(username);

2)删除
alter table user2 drop index u_username;

3.普通
1)添加
alter table user2 add index i_username(username);

2)删除
alter table user2 drop index i_username;

数据库操作:
1.DCL 数据控制语言
1)grant
2)commit
3)rollback

2.DDL 数据定义语言
1)create
2)drop
3)alter

3.DML 数据操作语言
1)insert
2)delete
3)update

4.DQL 数据查询语言
1)select


创建表语句:
mysql> create table user(
    -> id int unsigned auto_increment primary key,
    -> username varchar(50) not null,
    -> password varchar(50) not null
    -> );

表结构:
mysql> desc user;
+----------+------------------+------+-----+---------+----------------+
| Field    | Type             | Null | Key | Default | Extra          |
+----------+------------------+------+-----+---------+----------------+
| id       | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| username | varchar(50)      | NO   |     | NULL    |                |
| password | varchar(50)      | NO   |     | NULL    |                |
+----------+------------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

判断sql语句的检索效率:
desc select * from user where id=5;

增-insert:
insert into user(username,password) values('user1','123');

删-delete:
delete from user where id=5;

改-update:
update user set password='123' where id=2;
update user set username='user33',password='123' where id=3;

查-select:
select * from user;


#查询表中所有字段以及每个字段所对应的所有记录

where条件:
1.id>3
select * from user where id>3;

2.id>=3
select * from user where id>=3;

3.id<3;
select * from user where id<3;

4.id<=3;
select * from user where id<=3;

5.id>3 and id<7
select * from user where id>3 and id<7;

6.id>=3 and id<=7
select * from user where id>=3 and id<=7;

7.between 3 and 7
select * from user where id between 3 and 7;

8.id=3 or id=5 or id=6 or id=10
select * from user where id=3 or id=5 or id=6 or id=10;

9.in(3,5,6,10)
select * from user where id in(3,5,6,10);




今天内容-select:
--------------------------------------------------------
查询一般优化:
1.查单列的速度要优于多列.
2.查主键索引的列中的所有值要比其他列速度快.

选择特定的字段:
select id,username from user;

给字段名起别名:
select username （原名）as user（别名）,password as pass from user;
select username user,password pass from user;

distinct关键字的使用:
select distinct password from user;

使用where条件进行查询:
select * from user where id>=3 and id<=5;

between and的使用方法:
select * from user where id between 3 and 5;

or的使用方法:
select * from user where id=3 or id=5 or id=7;

in的使用方法:
select * from user where id in(3,5,7);

like的使用方法:
select * from user where username like '%user1%';（能匹配只要有user1都能匹配到）


