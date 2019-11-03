　快速预览，这些可以在官方的文档上找到更详细的资料。

　　@BeforeSuite:        被注释的方法将在所有测试运行前运行
　　@AfterSuite:        被注释的方法将在所有测试运行后运行

　　@BeforeTest:        被注释的方法将在测试运行前运行
　　@AfterTest:        被注释的方法将在测试运行后运行

　　@BeforeGroups:        被配置的方法将在列表中的gourp前运行。这个方法保证在第一个属于这些组的测试方法调用前立即执行。
　　@AfterGroups:        被配置的方法将在列表中的gourp后运行。这个方法保证在最后一个属于这些组的测试方法调用后立即执行。

　　@BeforeClass:        被注释的方法将在当前类的第一个测试方法调用前运行。
　　@AfterClass:        被注释的方法将在当前类的所有测试方法调用后运行。

　　@BeforeMethod:        被注释的方法将在每一个测试方法调用前运行。
　　@AfterMethod:        被注释的方法将在每一个测试方法调用后运行。


Actions action = new Actions(driver);
action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();//新开一个tab页

action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).keyUp(Keys.CONTROL).perform();//切换tab页


养殖通过中台搭建
养殖系统，后期需要改造，架构调整
细化节点，项目开发的里程碑
作息时间

服务器
git 

需求确认

数据采集，通过大数据分析结果；

通威水产项目