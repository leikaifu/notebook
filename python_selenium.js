# -*- coding: utf-8 -*-  
from selenium import webdriver
import time

driver = webdriver.Chrome()  
driver.maximize_window()
driver.implicitly_wait(20) # 隐性等待，最长等30秒  
driver.get('https://www.baidu.com')
time.sleep(3)
driver.find_element_by_id("kw").send_keys("hello")
driver.find_element_by_id("su").click()
driver.quit()

确认元素定位是否正确：都是在consle下面执行
jquery:
$('#su').click(function(){console.log(111)})
$('#su').click()

js:
document.getElementById('su').onclick = function(){console.log(1111)}


1.强制等待（sleep）
设置等待最简单的方法就是强制等待，其实就是time.sleep()方法，不管它什么情况，让程序暂停运行一定时间，
时间过后继续运行；缺点时不智能，设置的时间太短，元素还没有加载出来，那照样会报错；设置的时间太长，则会
浪费时间，不要小瞧每次几秒的时间，case多了，代码量大了，很多个几秒就会影响整体的运行速度了；所以尽量少
用这个
2.隐性等待（implicitly_wait()）
driver.implicitly_wait()，隐性等待设置了一个时间，在一段时间内网页是否加载完成，如果完成了，就进行下
一步；在设置的时间内没有加载完成，则会报超时加载；

3.显性等待（WebDriverWait）
WebDriverWait(driver, 20, 0.5).until(expected_conditions.presence_of_element_located(locator))，
selenium中的wait模块的WebDriverWait()方法，配合until或者until_not方法，再辅助以一些判断条件，就可以构
成这样一个场景：每经过多少秒就查看一次locator的元素是否可见，如果可见就停止等待，如果不可见就继续等待直到
超过规定的时间后，报超时异常；当然也可以判断某元素是否在规定时间内不可见等等的各种场景吧，需要根据你自己实
际的场景选择判断条件；


从主页面到子页面，句柄还停留在主页面，所以无法定位到子页面的元素，将窗口重新定位即可
driver.switch_to_window(driver.window_handles[1])

