运用python中常见问题总结

1、Python读取ini文件需要用到 ConfigParser 模块
关于ConfigParser模块的介绍详情请参照官网解释：https://docs.python.org/2.7/library/configparser.html
2、要读取的ini文件（configfile.ini）如下：
以"[browserType ]"做section,browserName 为options
3.文件路径：./config/new.ini  这个路径里面的"./"其实是可以省略的。
"./"  表示当前文件夹
"../" 表示当前文件夹的上一级文件夹
相对路径
