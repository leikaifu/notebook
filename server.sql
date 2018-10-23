
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

（2）服务器配置网卡（自动获取IP地址）
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
:wq! 或者 :wq  --退出并保存；

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
