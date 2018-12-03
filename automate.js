
自动化测试资源储备：

https://restlet.com/documentation/client/user-guide/automate/integrate-with-ci


Java+selenium 环境应用：

当我们使用selenium 实现模拟登陆时，获取到登陆按钮元素后，直接调用它的click()方法就能实现登陆跳转，
并且此时的webDriver 也是指向 
当前页面，这个是没问题的，不过需要注意的是因为页面加载速度一般小于程序运行速度，
所以在获取登陆后页面的元素之前，可以用WebDriverWait的util方法解决，也可以直接通过Thread.sleep()
让程序睡眠一会（不推荐）。

但是博主要说的重点是如果我们是通过点击普通超链接进入到新页面，那么通过上面的方法是获取不到新页面元素的，
因为此时的webDriver 依然指向之前的页面， 
解决方法：首先获取窗口的所有句柄，然后遍历这个句柄集合，
直到存在句柄（handle）与当前窗口的句柄(currentHandle)不一样，将之前的webDriver 转到新的
句柄（handle）所指向的页面。

代码如下：
String currentWindow=driver.getWindowHandle();   //获取当前窗口的句柄

        Set<String> handles=driver.getWindowHandles(); //获取所有窗口的句柄
        Iterator<String> it=handles.iterator();
        WebDriver newDriver=null;
        while (it.hasNext()){
            String handle=it.next();
            if(!handle.equals(currentWindow)){
                driver=driver.switchTo().window(handle);   //切换到新的句柄所指向的窗口
                break;
            }
        }


2018年11月1日：
图片上传：
  首先找到元素：WebElement  file = driver.findElement(By.name("filename"));
  给此元素设置值：file.sendKeys("E:\testfile.jpg");

鼠标事件：
参数:
    1.driver是我们的浏览器
    2.Actions是我们系统内置的执行鼠标一系列操作的对象
鼠标左击:Actions actions=new Actions(driver);
        actions.click(这里传入我们需要点击的控件元素,WebElement类型).perform();
        //例如:
        //找到我们慕课网首页登录的id
        WebElement login=driver.findElement(By.id("js-signin-btn"));
        //创建动作对象，并且指定操作的浏览器
        Actions actions=new Actions(driver);
        //单击操作传入参数，并且使用perform()提交,生效
        actions.click(login).perform();
鼠标右击:Actions actions=new Actions(driver);
        actions.contextClick(这里传入我们需要点击的控件元素,WebElement类型).perform();
//鼠标双击:鼠标双击的效果跟我们实际自己点击两次的效果有些出入，也不是那么智能
    Actions actions=new Actions(driver);
    actions.doubleClick(login).perform();
鼠标悬停:
    Actions actions=new Actions(driver);
    actions.moveToElement(这里传入我们需要点击的控件元素,WebElement类型).perform();

下面的所有的在Java中 单词间隔的下滑线省略不写；

click(on_element=None) ——单击鼠标左键

click_and_hold(on_element=None) ——点击鼠标左键，不松开

context_click(on_element=None) ——点击鼠标右键

double_click(on_element=None) ——双击鼠标左键

drag_and_drop(source, target) ——拖拽到某个元素然后松开

drag_and_drop_by_offset(source, xoffset, yoffset) ——拖拽到某个坐标然后松开

key_down(value, element=None) ——按下某个键盘上的键

key_up(value, element=None) ——松开某个键

move_by_offset(xoffset, yoffset) ——鼠标从当前位置移动到某个坐标

move_to_element(to_element) ——鼠标移动到某个元素

move_to_element_with_offset(to_element, xoffset, yoffset) ——移动到距某个元素（左上角坐标）多少距离的位置

perform() ——执行链中的所有动作

release(on_element=None) ——在某个元素位置松开鼠标左键

send_keys(*keys_to_send) ——发送某个键到当前焦点的元素

send_keys_to_element(element, *keys_to_send) ——发送某个键到指定元素

3.ActionChains的其他操作：移动鼠标、右击、双击、结合键盘按键的操作等。。。

context_click(element) :   

右击element元素

 

double_click(element)： 

 双击element元素

 

move_by_offset(xoffset，yoffset)：   

移动鼠标到指定的x，y位置（相对于浏览器的绝对位置）

 

move_to_element_with_offset(element, xoffset, yoffset):

相对element元素,移动鼠标到指定的x，y位置(相对于element元素的相对位置)

 

click_and_hold(element1=None)：   

在element1元素上按下鼠标左键，并保持按下动作（元素默认为空）

 

release(element2=None):    

 在element2元素上松开鼠标左键（元素默认为空）

 

key_down(key , element1=None)：    

在element1元素上，按下指定的键盘key（ctrl、shift等）键，并保持按下动作（元素默认为空）

 

key_up(key , element2=None)：  

   在element2元素上，松开指定的键盘key（元素默认为空）

 

send_keys(key):  

向当前定位元素发送某个key键

 

send_keys_to_element(element ，key)：

向element元素发送某个key键


window.frames[0];


2018年11月5日
学习任务：
1、
JavaScriptExecutor js=(JavaScriptExecutor)driver;
js.executeScript("");

2、
public void JavaScriptClick(WebElement element) {
        jsexecutor = (JavascriptExecutor) driver;
        try {
            // 判断传入的element元素是否处于可单击状态，以及是否能显示在页面上
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("使用JavaScript进行页面元素的单击");
                // 执行JavaScript语句arguments[0].click();
                //argumets[0]表示第一个参数，即element
                jsexecutor.executeScript("arguments[0].click();", element);
            } else {
                System.out.println("页面上的元素无法进行单击操作");
            }
        } catch (StaleElementReferenceException e) {
            // TODO: handle exception
            System.out.println("页面元素没有附加在网页中"+e.getStackTrace());
        } catch (NoSuchElementException e) {
            // TODO: handle exception
            System.out.println("在页面中没有找到要操作的元素"+e.getStackTrace());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("无法完成单击动作"+e.getStackTrace());
        }
    }

3、
$(document.querySelectorAll('input[type=button]'))=$('input[type=button]')
document.querySelectorAll()  css选择器js原生的
4、
 //从ifrmae里面回到初始状态；
driver.switchTo().defaultContent();
（5）
 WebElement webElement=driver.findElement(By.cssSelector("定位元素"));
 //切换到frmae里面
    driver.switchTo().frame(webElement);
（6）
String handle=driver.getWindowHandle();

        for (String hand:driver.getWindowHandles()){
            System.out.println("所以句柄："+driver.getWindowHandles());
            if (hand.equals(handle))
                continue;
            driver.switchTo().window(hand);
            System.out.println(hand);
        }

2018年11月6日
学习任务：

通过for循环及if语句，进入新打开的窗口。代码参考：

for handle in all_handles:

    if handle != current_window:

        driver.switch_to.window(handle)



回到之前的窗口

for handle in all_handles:

    if handle == current_window:

        driver.switch_to.window(handle)

public static boolean switchToWindow(String windowTitle,WebDriver dr){  
        boolean flag = false;  
        try { 
            //将页面上所有的windowshandle放在入set集合当中
            String currentHandle = dr.getWindowHandle();  
            Set<String> handles = dr.getWindowHandles();  
            for (String s : handles) {  
                if (s.equals(currentHandle))  
                    continue;  
                else {  
                    dr.switchTo().window(s);
            //和当前的窗口进行比较如果相同就切换到windowhandle
            //判断title是否和handles当前的窗口相同
                    if (dr.getTitle().contains(windowTitle)) {  
                        flag = true;  
                        System.out.println("Switch to window: "  
                                + windowTitle + " successfully!");  
                        break;  
                    } else  
                        continue;  
                }  
            }  
        } catch (Exception e) {  
            System.out.printf("Window: " + windowTitle  
                    + " cound not found!", e.fillInStackTrace());  
            flag = false;  
        }  
        return flag;  
    } 



第二种通过索引切换窗口

public class ManyHandleChange {
    private static WebDriver driver;
    public static void main(String[] args) throws Exception {
//      E:\eclipse_jar\selenium_jar\chromedriver_lastest\chromedriver.exe
//      E:\eclipse_jar\selenium_jar\chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "E:\\eclipse_jar\\selenium_jar\\chromedriver_lastest\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get("http://www.baidu.com/");  //打开百度首页
//      String window_one = driver.getWindowHandle();
        Thread.sleep(2000);
        
        ((JavascriptExecutor)driver).executeScript("window.open('http://www.sogou.com/')");  //用js打开新的窗口
        Thread.sleep(2000);
        
        ((JavascriptExecutor)driver).executeScript("window.open('http://www.youdao.com/')");  //用js打开新的窗口
        Thread.sleep(2000);
        
        ((JavascriptExecutor)driver).executeScript("window.open('http://www.qq.com/')");  //用新浪打开新的窗口
        Thread.sleep(2000);
        
        Set<String> allWindow = driver.getWindowHandles();  //获取所有的窗口句柄
        List<String> it = new ArrayList<String>(allWindow);  //将set集合存入list对象中
        System.out.println(allWindow.size());  //输出句柄集合
        
        /**
         * list集合的索引是从0开始
         * 窗口在list中索引对应的窗口顺序是：第一个打开的窗口（百度）索引是0；
         * 其他窗口对应的索引顺序是：最后一个打开的窗口（腾讯）索引是1，剩余的窗口索引依次是打开窗口顺序的倒序，即2是有道，3是搜狗
         */
        //通过list的索引切换窗口
        //切换到腾讯窗口
        driver.switchTo().window(it.get(1));
        String title = driver.getTitle();  //获取当前窗口的title
        System.out.println("已切换到：" + title);  
        Thread.sleep(500);
        driver.close();  //关闭当前窗口
        System.out.println(title + ":已经关闭！");
        Thread.sleep(1000);
        
        //切换到有道窗口
        driver.switchTo().window(it.get(2));
        String title1 = driver.getTitle();  //获取当前窗口的title
        System.out.println("已切换到：" + title1);
        Thread.sleep(500);
        driver.close();  //关闭当前窗口
        System.out.println(title1 + ":已经关闭！");
        Thread.sleep(1000);
        
        //切换到搜狗窗口
        driver.switchTo().window(it.get(3));
        String title2 = driver.getTitle();   //获取当前窗口的title
        System.out.println("已切换到：" + title2);
        Thread.sleep(500);
        driver.close();  //关闭当前窗口
        System.out.println(title2 + ":已经关闭！");
        Thread.sleep(1000);
        
        //切换到百度窗口
        driver.switchTo().window(it.get(0));
        String title3 = driver.getTitle();   //获取当前窗口的title
        System.out.println("已切换到：" + title3);
        Thread.sleep(500);
        driver.close();  //关闭当前窗口
        System.out.println(title3 + ":已经关闭！");
        Thread.sleep(1000);
        
        /**
         * 使用循环来实现窗口之间的相互切换、关闭
         */
//      for(String i:allWindow) {
//          if(i != window_one) {  //判断当前是否是第一个窗口
//              driver.switchTo().window(i);  //如果不是，则切换到当前窗口
//              System.out.println("成功切换到：" + driver.getTitle());  //为了证明确实切换了，打印一下窗口的title
//              Thread.sleep(2000);
//              /**
//               * 截取当前窗口的图片并保存到指定文件夹中
//               */
//              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //设置时间格式
//              String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
//              File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //执行屏幕截取
//              FileUtils.copyFile(srcFile, new File("snapshot", time+".png"));  //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件
//              driver.close();
//          }
//          Thread.sleep(2000);
//      }
    }
    


2018年11月7日
学习任务：


public class WindowTest2 {
    public WebDriver driver;
    public String wH;
    //初始化chrome浏览器驱动,并且让chrome浏览器打开慕课网首页
    public void initDriver() 
    {
        System.setProperty("webdriver.chrome.driver", "D:\\java\\chromedriver-32\\chromedriver.exe");
        //初始化chrome浏览器
        driver=new ChromeDriver();
        driver.get("http://www.imooc.com/");
        //屏幕最大化
        driver.manage().window().maximize();
    }
    /*
     * 使用Action执行鼠标左击,右击,双击,悬停操作
     * 
     * */
    public void actionTest() {
        //找到我们慕课网首页包含前段开发,后端开发,移动开发等着一系列条目的className
        WebElement login=driver.findElement(By.className("menuContent"));
        //List集合接收前段开发,后端开发,移动开发的条目，注意用的是findElements不是findElement，多一个"s"
        List<WebElement> elements=login.findElements(By.className("item"));
        //创建动作对象，并且指定操作的浏览器
        Actions actions=new Actions(driver);
        //单击操作传入参数，并且使用perform()提交,生效
        //actions.click(login).perform();
        //双击操作
        //actions.doubleClick(login).perform();
        //右击操作
        //actions.contextClick(login).perform();
        //actions.moveToElement().perform();
        //鼠标悬停在List集合的第一个元素即"前段开发"
        actions.moveToElement(elements.get(0)).perform();
        //得到当前的窗口
        wH=driver.getWindowHandle();
        //点击"前段开发"中包含的"HTML/CSS"条目
        driver.findElement(By.partialLinkText("HTML/CSS")).click();
    }
    /*
     * 窗口
     * */
    public void windowHandle()
    {
        //采用如下方法，会报错:no such element: Unable to locate element: {"method":"tag name","selector":"案例"}
        //主要还是父子元素出错
        //driver.findElement(By.tagName("案例")).click();
        //那么我们采用如下代码还是不会通过,原因主要是我们这里操作的是窗口值String类型,而不是之前类似的条目元素值
//      WebElement window=driver.findElement(By.className("bd"));
//      List<WebElement> tt=window.findElements(By.tagName("li"));
//      driver.switchTo().window(tt.get(2));

        /*
         * 以下代码才是正确的
         * */
        Set<String> handles=driver.getWindowHandles();
        for(String s:handles) {
            if(s.equals(wH))
            {
                continue;

            }
            System.out.println(s);
            driver.switchTo().window(s);

        }
        driver.findElement(By.linkText("案例")).click();
    }
    public static void main(String[] args) {
        WindowTest2 wt2=new WindowTest2();
        wt2.initDriver();
        wt2.actionTest();
        wt2.windowHandle();
    }

}



 // 获取所有的打开窗口的句柄
        for (String windowId : allWindowsId) {
            if (driver.switchTo().window(windowId).getTitle().contains("博客园")) {
                driver.switchTo().window(windowId);
                break
            }
        }


// 进入 id 叫frameA 的 iframe
dr.switchTo().frame("frameA");

// 回到主窗口
dr.switchTo().defaultContent();



2018年11月12日
学习任务：

testng配置reportng报告
pom.xml配置文件

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.testngproj</groupId>
    <artifactId>testngproj</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.8</version>
        </dependency>

        <dependency>
            <groupId>org.uncommons</groupId>
            <artifactId>reportng</artifactId>
            <version>1.1.4</version>
            <scope>test</scope>
            <!--排除下面的jar包-->
            <exclusions>
                <exclusion>
                    <groupId>org.testng</groupId>
                    <artifactId>testng</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>com.google.inject</groupId>
            <artifactId>guice</artifactId>
            <version>3.0</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <!--添加Surefire插件-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.5</version>
                <configuration>
                    <properties>
                        <property>
                            <name>usedefaultlisteners</name>
                            <value>false</value>
                        </property>
                        <property>
                            <name>listener</name>
                            <value>org.uncommons.reportng.HTMLReporter, org.uncommons.reportng.JUnitXMLReporter</value>
                        </property>
                    </properties>
                    <workingDirectory>target/</workingDirectory>
                </configuration>
            </plugin>

// 过滤不能通过执行案列
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.5</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                    <suiteXmlFiles>
                        <file>res/testNG.xml</file>
                    </suiteXmlFiles>
                    <!--<workingDirectory>target/</workingDirectory>-->
                </configuration>
            </plugin>

        </plugins>
    </build>

</project>


testng 按组测试
配置文件

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite1">
    <test name="test1">
        <groups>
            <run>
                 <include name="functiontest" />
            </run>
         </groups>
    </test>
</suite>



2018年11月15日
学习任务：
//给一个元素附上一个值
<script>
    var value=document.getElementById("name1").value;
    document.getElementById("name2").value=value;
</script>

$("id").val("123")


鼠标点击操作 
鼠标点击事件有以下几种类型： 

1. 鼠标左键点击 
 Actions action = new Actions(driver);
 action.click();// 鼠标左键在当前停留的位置做单击操作  
action.click(driver.findElement(By.name(element)))// 鼠标左键点击指定的元素 

2. 鼠标右键点击 
 Actions action = new Actions(driver);  
 action.contextClick();// 鼠标右键在当前停留的位置做单击操作  
action.contextClick(driver.findElement(By.name(element)))// 鼠标右键点击指定的元素 

3. 鼠标双击操作 
 Actions action = new Actions(driver);  
 action.doubleClick();// 鼠标在当前停留的位置做双击操作  
 
var script = document.createElement('script'); 
script.src = 'http://static.pay.baidu.com/resource/baichuan/ns.js';
 document.body.appendChild(script);    
action.doubleClick(driver.findElement(By.name(element)))// 鼠标双击指定的元素 

4. 鼠标拖拽动作 
 Actions action = new Actions(driver);  
// 鼠标拖拽动作，将 source 元素拖放到 target 元素的位置。  action.dragAndDrop(source,target); 
// 鼠标拖拽动作，将 source 元素拖放到 (xOffset, yOffset) 位置，其中 xOffset 为横坐标，yOffset 为纵坐标。 
action.dragAndDrop(source,xOffset,yOffset); 
在这个拖拽的过程中，已经使用到了鼠标的组合动作，首先是鼠标点击并按住 
(click-and-hold) source 元素，然后执行鼠标移动动作 (mouse move)，移动到 target 元素位置或者是 (xOffset, yOffset) 位置，再执行鼠标的释放动作 (mouse release)。所以上面的方法也可以拆分成以下的几个执行动作来完成： 
action.clickAndHold(source).moveToElement(target).perform();   
action.release(); //鼠标释放

5. 鼠标悬停操作 
 Actions action = new Actions(driver);  
 action.clickAndHold();// 鼠标悬停在当前位置，既点击并且不释放  action.clickAndHold(onElement);// 鼠标悬停在 onElement 元素的位置 
action.clickAndHold(onElement) 这个方法实际上是执行了两个动作，首先是鼠标移动到元素 onElement，
然后再 clickAndHold, 所以这个方法也可以写成 action.moveToElement(onElement).clickAndHold()。 

6. 鼠标移动操作 
 Actions action = new Actions(driver);  
 action.moveToElement(toElement);// 将鼠标移到 toElement 元素中点 // 将鼠标移到元素 toElement 的 (xOffset, yOffset) 位置， 
//这里的 (xOffset, yOffset) 是以元素 toElement 的左上角为 (0,0) 开始的 (x, y) 坐标轴。 
 var cpro_psid ="u2572954"; var cpro_pswidth =966; var cpro_psheight =120;
 action.moveToElement(toElement,xOffset,yOffset) 
// 以鼠标当前位置或者 (0,0) 为中心开始移动到 (xOffset, yOffset) 坐标轴  action.moveByOffset(xOffset,yOffset); 
action.moveByOffset(xOffset,yOffset) 这里需要注意，如果 xOffset 为负数，表示横坐标向左移动，
yOffset 为负数表示纵坐标向上移动。而且如果这两个值大于当前屏幕的大小，鼠标只能移到屏幕最边界的位置同时抛出
 MoveTargetOutOfBoundsExecption 的异常。
  鼠标移动操作在测试环境中比较常用到的场景是需要获取某元素的 flyover/tips，
  实际应用中很多 flyover 只有当鼠标移动到这个元素之后才出现，所以这个时候通过执行 
moveToElement(toElement) 操作，就能达到预期的效果。但是根据我个人的经验，这个方法对于某些特定产品的图标，
图像之类的 flyover/tips 也不起作用，虽然在手动操作的时候移动鼠标到这些图标上面可以出现 flyover, 
但是当使用 WebDriver 来模拟这一移动操作时，虽然方法成功执行了，但是 flyover 却出不来。
所以在实际应用中，还需要对具体的产品页面做相应的处理。

7. 鼠标释放操 
 Actions action = new Actions(driver);   
 action.release();// 释放鼠标 


弹窗处理

1、Alert alt = driver.switchTo().alert();
    alt.accept();//确定
    alt.dismiss();//取消

2、