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

#动态标签的节点获取方法:

div动态加载完以后，显示多个子节点，./div/div/div/*（*以后的节点:  div/i，div/span，i和span并列同级，i在前span在后） 
1、webelement=//div[@class='ivu-message-notice-content']/child::* 
webelement.getTagName()  得到div
2、//div[@class='ivu-message-notice-content']/div/child::* 
webelement.getTagName()  得到i
3、//div[@class='ivu-message-notice-content']/div/i/child::*
webelement.getTagName()  得到NoSuchElementException，说明i已经是最后一层。
4、//div[@class='ivu-message-notice-content']/div/i/following-sibling::*
webelement.getTagName()  得到span，说明i有一个同级span。
5、//div[@class='ivu-message-notice-content']/div/span/following-sibling::*
webelement.getTagName()  得到NoSuchElementException，说明span已经是最后一个标签。



//div/div[@class='ant-message']/span/div[@class='ant-message-notice']//span 

#使用classname定位时，class属性应该是唯一的才行，如果class里面有多个时，出现空格，会报错；

class=“hello  welcome”  这种就不可以使用classname定位

class=“hello”    这种就可以使用classname定位



collect=[{"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"applyInfo-totalApplyAmountCapital","valueType":"java.lang.String","name":"applyInfo-totalApplyAmountCapital","placeholder":"请输入大写的申请金额合计","is_allowClear":false,"addonBefore":"","guide":"请输入大写的申请金额合计"}, {"maxlength":64,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"applyNo","valueType":"java.lang.String","name":"applyNo","placeholder":"请输入申请单单号","is_allowClear":false,"addonBefore":"","guide":"请输入申请单单号"}, {"field":"applyDate","startedtime":"","defaultValue":"","controltype":"date","endedtime":"","valueType":"java.util.Date","name":"applyDate","format":"YYYY-MM-DD","is_allowClear":false,"placeholder":"请选择申请日期","type":"date","guide":"请选择申请日期"}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"jobLevel","valueType":"java.lang.String","name":"jobLevel","placeholder":"请输入职务级别","is_allowClear":false,"addonBefore":"","guide":"请输入职务级别"}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"staffNo","valueType":"java.lang.String","name":"staffNo","placeholder":"请输入员工编号","is_allowClear":false,"addonBefore":"","guide":"请输入员工编号"}, {"is_thousandsseparator":false,"field":"budgetYear","defaultValue":"","controltype":"integer","precision":0,"valueType":"java.lang.Integer","name":"budgetYear","step":1,"placeholder":"请输入预算年度","type":"number","guide":"请输入预算年度"}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"applyInfo-totalApprovalAmountCapital","valueType":"java.lang.String","name":"applyInfo-totalApprovalAmountCapital","placeholder":"请输入大写的审批金额合计","is_allowClear":false,"addonBefore":"","guide":"请输入大写的审批金额合计"}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"companyCode","valueType":"java.lang.String","name":"companyCode","placeholder":"请输入公司代码","is_allowClear":false,"addonBefore":"","guide":"请输入公司代码"}, {"datasourcetype":"items","buttons":{"add":{"hidden":false},"batchdelete":{"hidden":false},"delete":{"hidden":false}},"is_hightPerformance":false,"defaultValue":"","controltype":"lineeditortable","is_justoneline":false,"itemsTableBtns":{"add":"新增一行","batchdelete":"批量删除","downloadTemplate":"导出模板","search":"搜索","reload":"重置","showUploadLog":"查看导入日志","downloadNowData":"导出现有内容","uploadExcel":"导入模板","delete":"删除"},"type":"table","is_exportexcel":false,"field":"tgroup-details","valueType":"com.bizunited.platform.formengine.testserver.entity.ApprovalCostApplyDetailsEntity","name":"tgroup-details","scrolly":"","items":{"columns":[{"canUpdate":false,"nullable":false,"hidden":true,"canInsert":true,"propertyDbName":"id","index":1,"control":"input","readOnly":true,"title":"主键","required":false,"field":"id","propertyName":"id","propertyDesc":"主键","unique":true,"valueType":"java.lang.String","name":"id","disabled":true,"id":"87fcbcd6-56b1-4d97-b531-eea98a9510b7","defaultController":"","maxLen":0,"propertyClassName":"java.lang.String","primaryKey":true},{"nullable":false,"hidden":false,"defaultValue":"1","propertyDbName":"cost_type","title":"费用类型","required":true,"valueType":"java.lang.Integer","defaultValues":"1,0","disabled":false,"id":"ae55835a-d648-49e7-8c48-dfea5f85ab83","defaultController":"SELECT","maxLen":2,"canUpdate":true,"canInsert":true,"defaultKeys":"共性费用,各部门费用","index":2,"control":"select.single","readOnly":false,"field":"costType","propertyName":"costType","propertyDesc":"费用类型","unique":false,"name":"costType","dataSource":{"datasourcetype":"local","local":{"data":[{"label":"共性费用","value":"1"},{"label":"各部门费用","value":"0"}]}},"propertyClassName":"java.lang.Integer","primaryKey":false},{"nullable":false,"hidden":false,"defaultValue":"1","propertyDbName":"approval_cost_desc","title":"费用项目描述","required":true,"valueType":"java.lang.Integer","defaultValues":"1,0","disabled":false,"id":"1dee01b2-3763-4bf4-a00f-5e33fedd64f6","defaultController":"SELECT","maxLen":2,"canUpdate":true,"canInsert":true,"defaultKeys":"内部用,外部用","index":3,"control":"select.single","readOnly":false,"field":"approvalCostDesc","propertyName":"approvalCostDesc","propertyDesc":"费用项目描述","unique":false,"name":"approvalCostDesc","dataSource":{"datasourcetype":"local","local":{"data":[{"label":"内部用","value":"1"},{"label":"外部用","value":"0"}]}},"propertyClassName":"java.lang.Integer","primaryKey":false},{"nullable":false,"hidden":false,"defaultValue":"1","propertyDbName":"mini_cost_desc","title":"费用小类描述","required":true,"valueType":"java.lang.Integer","defaultValues":"1,0","disabled":false,"id":"569ad507-0780-4dd3-afa9-2e04ba8581cd","defaultController":"SELECT","maxLen":2,"canUpdate":true,"canInsert":true,"defaultKeys":"一般,杂项","index":4,"control":"select.single","readOnly":false,"field":"miniCostDesc","propertyName":"miniCostDesc","propertyDesc":"费用小类描述","unique":false,"name":"miniCostDesc","dataSource":{"datasourcetype":"local","local":{"data":[{"label":"一般","value":"1"},{"label":"杂项","value":"0"}]}},"propertyClassName":"java.lang.Integer","primaryKey":false},{"canUpdate":true,"nullable":false,"hidden":false,"canInsert":true,"propertyDbName":"apply_amount","index":5,"control":"number","readOnly":false,"title":"申请金额","required":true,"field":"applyAmount","propertyName":"applyAmount","propertyDesc":"申请金额","unique":false,"valueType":"java.math.BigDecimal","name":"applyAmount","disabled":false,"id":"c5e429c3-f23f-49e0-9abe-cc31dae70e50","defaultController":"","maxLen":255,"propertyClassName":"java.math.BigDecimal","primaryKey":false},{"canUpdate":true,"nullable":false,"hidden":false,"canInsert":true,"propertyDbName":"approval_amount","index":6,"control":"number","readOnly":false,"title":"审批金额","required":true,"field":"approvalAmount","propertyName":"approvalAmount","propertyDesc":"审批金额","unique":false,"valueType":"java.math.BigDecimal","name":"approvalAmount","disabled":false,"id":"27c091db-f2f9-436c-b8c5-89ad4f762493","defaultController":"","maxLen":255,"propertyClassName":"java.math.BigDecimal","primaryKey":false},{"canUpdate":true,"nullable":false,"hidden":false,"canInsert":true,"propertyDbName":"budget_amount","index":7,"control":"number","readOnly":false,"title":"预算金额","required":true,"field":"budgetAmount","propertyName":"budgetAmount","propertyDesc":"预算金额","unique":false,"valueType":"java.math.BigDecimal","name":"budgetAmount","disabled":false,"id":"7e5fc715-aadb-4612-b162-264b9ff3b850","defaultController":"","maxLen":255,"propertyClassName":"java.math.BigDecimal","primaryKey":false},{"canUpdate":true,"nullable":false,"hidden":true,"canInsert":true,"propertyDbName":"itemNo","index":8,"control":"input","readOnly":false,"title":"序号","required":true,"field":"itemNo","propertyName":"itemNo","propertyDesc":"序号","unique":false,"valueType":"java.lang.String","name":"itemNo","disabled":false,"id":"428722e6-acaf-4054-b9ce-b5a3479d396d","defaultController":"","maxLen":255,"propertyClassName":"java.lang.String","primaryKey":false}],"templateItemId":"a4e71b42-5c83-4f30-b7a1-170c76c545df"},"guide":""}, {"is_thousandsseparator":false,"field":"applyInfo-totalApprovalAmount","defaultValue":"","controltype":"decimal","precision":0,"valueType":"java.math.BigDecimal","name":"applyInfo-totalApprovalAmount","step":1,"placeholder":"请输入审批金额合计","type":"number","guide":"请输入审批金额合计"}, {"field":"applyInfo-declareItemContent","maxlength":1024,"defaultValue":"","valueType":"java.lang.String","name":"applyInfo-declareItemContent","placeholder":"请输入申报项目内容（完工期限、质量要求、技术要求等）","type":"texteditor","guide":"请输入申报项目内容（完工期限、质量要求、技术要求等）"}, {"field":"applyInfo-applyReason","maxlength":1024,"defaultValue":"","valueType":"java.lang.String","name":"applyInfo-applyReason","placeholder":"请输入申请理由及依据","type":"texteditor","guide":"请输入申请理由及依据"}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"applyInfo-projectName","valueType":"java.lang.String","name":"applyInfo-projectName","placeholder":"请输入项目名称","is_allowClear":false,"addonBefore":"","guide":"请输入项目名称"}, {"defaultValue":"","controltype":"print","name":"btnPrint","icon":"printer","text":"打印","type":"button","guide":""}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"applyUserId","valueType":"java.lang.String","name":"applyUserId","placeholder":"请输入申请人","is_allowClear":false,"addonBefore":"","guide":"请输入申请人"}, {"defaultValue":"","controltype":"close","name":"btnClose","icon":"close","text":"关闭","type":"button","guide":""}, {"defaultValue":"","controltype":"reset","name":"btnReset","icon":"retweet","text":"重置","type":"button","guide":""}, {"maxlength":64,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"title","valueType":"java.lang.String","name":"title","placeholder":"请输入标题","is_allowClear":false,"addonBefore":"","guide":"请输入标题"}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"staffCall","valueType":"java.lang.String","name":"staffCall","placeholder":"请输入员工联系方式","is_allowClear":false,"addonBefore":"","guide":"请输入员工联系方式"}, {"datasourcetype":"local","notFoundContent":"数据加载中...请稍后","field":"biddingParity","defaultValue":"1","controltype":"single","valueType":"java.lang.Byte","name":"biddingParity","is_allowClear":false,"placeholder":"请选择是否需要比价招标","type":"select","guide":"请选择是否需要比价招标","local":{"data":[{"label":"是","value":"1"},{"label":"否","value":"0"}]}}, {"defaultValue":"","controltype":"submit","name":"btnSubmit","icon":"check","text":"提交","type":"button","guide":""}, {"defaultValue":"","controltype":"tempsubmit","name":"btnTempSubmit","icon":"check","text":"暂存","type":"button","guide":""}, {"maxlength":255,"defaultValue":"","controltype":"text","type":"input","addonAfter":"","regex":"","regexerrmessage":"","field":"applyOrgId","valueType":"java.lang.String","name":"applyOrgId","placeholder":"请输入申请人部门","is_allowClear":false,"addonBefore":"","guide":"请输入申请人部门"}, {"field":"applyInfo-serviceRequirement","maxlength":1024,"defaultValue":"","valueType":"java.lang.String","name":"applyInfo-serviceRequirement","placeholder":"请输入服务要求（产品运送地点、质保期、售后服务）","type":"texteditor","guide":"请输入服务要求（产品运送地点、质保期、售后服务）"}, {"is_thousandsseparator":false,"field":"applyInfo-totalApplyAmount","defaultValue":"","controltype":"decimal","precision":0,"valueType":"java.math.BigDecimal","name":"applyInfo-totalApplyAmount","step":1,"placeholder":"请输入申请金额合计","type":"number","guide":"请输入申请金额合计"}]






