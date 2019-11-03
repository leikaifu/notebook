
#Java代码名规范：
	包名：全部小写，不需要驼峰命名；
	类名：首字母大写驼峰命名
	方法名：首字母小写，驼峰命名；

#TestNG使用ReportNG生成测试报告会更加美观。idea+maven+testngreport+selenium 生成测试报告；
#需要的依赖包如下：
pom配置文件：

	<name>Poj</name>
    <url>http://maven.apache.org</url>


    <properties>
        <xmlFileName>testng.xml</xmlFileName>
    </properties>

    <dependencies>
        <!-- 添加testNG依赖 -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.11</version>
            <scope>test</scope>
        </dependency>
        <!-- 添加reportNG依赖 -->
        <dependency>
            <groupId>org.uncommons</groupId>
            <artifactId>reportng</artifactId>
            <version>1.1.2</version>
            <scope>test</scope>
            <!-- 排除testNG依赖 -->
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

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.13.0</version>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-server</artifactId>
            <version>3.13.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.19</version>
                <configuration>
                    <skipTests>false</skipTests>
                    <suiteXmlFiles>
                        <suiteXmlFile>${xmlFileName}</suiteXmlFile>
                    </suiteXmlFiles>
                    <properties>
                        <property>
                            <name>usedefaultlisteners</name>
                            <value>false</value>
                        </property>
                        <property>
                            <name>listener</name>
                            <value>org.uncommons.reportng.HTMLReporter,org.uncommons.reportng.JUnitXMLReporter</value>
                        </property>
                    </properties>
                    <forkMode>always</forkMode>
                </configuration>
            </plugin>
        </plugins>
    </build>

#testng.xml 文件配置：

<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="orgTestSuite">
    <test name="百度搜索功能测试">
        <!--<packages>-->
            <!--<package name="com.*.*.service.XXServiceTest"/>-->
        <!--</packages>-->
        <classes>
            <class name="page"/>
        </classes>
    </test>
    <listeners>
        <listener class-name="org.uncommons.reportng.HTMLReporter"/>
        <listener class-name="org.uncommons.reportng.JUnitXMLReporter"/>
    </listeners>
</suite>


#跑一个里面的部分方法；
<test name="Test2">
   <classes>
      <class name="ProximatestCase.TestDecompression">
          <methods>
              	<include name="C" />
             	<include name="B" />
              	<include name="A" />
          </methods>
      </class>
    </classes>     
  </test>
  





#Java +selenium+testng 最新的一个配置测试报告；
将报告的json数据替换template文件中的${resultData}即可。

pull ztest。
读取template文件数据。
将测试报告数据json序列化。
用json序列化后的数据替换读取的template文件中的${resultData}。比如：
Gson gson = new GsonBuilder().disableHtmlEscaping().create();
String template = FileUtil.read(templatePath);
template = template.replaceFirst("\\$\\{resultData\\}", gson.toJson(result));
output.write(template);
将替换后的数据写入一个html文件(比如report.html)即可。
测试报告数据格式示例：
{
    "testPass": 1,
    "testResult": [
        {
            "className": "com.test.testcase.TestDemo1",
            "methodName": "testDemo",
            "description": "测试DEMO",
            "spendTime": "11ms",
            "status": "成功",
            "log": [
                "this is demo!"
            ]
        }
    ],
    "testName": "20171109132744897",
    "testAll": 1,
    "testFail": 0,
    "beginTime": "2017-11-09 13:27:44.917",
    "totalTime": "11ms",
    "testSkip": 0
}
Java TestNg使用示例
请参考ztest中的TestDemo1.java ZTestReport.java


