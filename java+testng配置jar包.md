

extentreports 依赖jar
------------------------------------------------------------------------------------------------------------------------------ 
1.产生报告需要的jar包：
<!-- extentreports -->
        <dependency>
            <groupId>com.relevantcodes</groupId>
            <artifactId>extentreports</artifactId>
            <version>2.41.1</version>
        </dependency>
        <dependency>
            <groupId>com.vimalselvam</groupId>
            <artifactId>testng-extentsreport</artifactId>
            <version>1.3.1</version>
        </dependency>
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>3.0.6</version>
        </dependency>
<!-- extentreports -->



httpclient
------------------------------------------------------------------------------------------------------------------------------
@Test
public void jUnitTest() {
    get();
}

/**
 * HttpClient连接SSL
 */
public void ssl() {
    CloseableHttpClient httpclient = null;
    try {
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream instream = new FileInputStream(new File("d:\\tomcat.keystore"));
        try {
            // 加载keyStore d:\\tomcat.keystore  
            trustStore.load(instream, "123456".toCharArray());
        } catch (CertificateException e) {
            e.printStackTrace();
        } finally {
            try {
                instream.close();
            } catch (Exception ignore) {
            }
        }
        // 相信自己的CA和所有自签名的证书
        SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
        // 只允许使用TLSv1协议
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        // 创建http请求(get方式)
        HttpGet httpget = new HttpGet("https://localhost:8443/myDemo/Ajax/serivceJ.action");
        System.out.println("executing request" + httpget.getRequestLine());
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                System.out.println(EntityUtils.toString(entity));
                EntityUtils.consume(entity);
            }
        } finally {
            response.close();
        }
    } catch (ParseException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (KeyManagementException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (KeyStoreException e) {
        e.printStackTrace();
    } finally {
        if (httpclient != null) {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * post方式提交表单（模拟用户登录请求）
 */
public void postForm() {
    // 创建默认的httpClient实例.  
    CloseableHttpClient httpclient = HttpClients.createDefault();
    // 创建httppost  
    HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceJ.action");
    // 创建参数队列  
    List<NAMEVALUEPAIR> formparams = new ArrayList<NAMEVALUEPAIR>();
    formparams.add(new BasicNameValuePair("username", "admin"));
    formparams.add(new BasicNameValuePair("password", "123456"));
    UrlEncodedFormEntity uefEntity;
    try {
        uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httppost.setEntity(uefEntity);
        System.out.println("executing request " + httppost.getURI());
        CloseableHttpResponse response = httpclient.execute(httppost);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("--------------------------------------");
                System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                System.out.println("--------------------------------------");
            }
        } finally {
            response.close();
        }
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e1) {
        e1.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // 关闭连接,释放资源  
        try {
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
 */
public void post() {
    // 创建默认的httpClient实例.  
    CloseableHttpClient httpclient = HttpClients.createDefault();
    // 创建httppost  
    HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceJ.action");
    // 创建参数队列  
    List<NAMEVALUEPAIR> formparams = new ArrayList<NAMEVALUEPAIR>();
    formparams.add(new BasicNameValuePair("type", "house"));
    UrlEncodedFormEntity uefEntity;
    try {
        uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httppost.setEntity(uefEntity);
        System.out.println("executing request " + httppost.getURI());
        CloseableHttpResponse response = httpclient.execute(httppost);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("--------------------------------------");
                System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                System.out.println("--------------------------------------");
            }
        } finally {
            response.close();
        }
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e1) {
        e1.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // 关闭连接,释放资源  
        try {
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 发送 get请求 无参数
 */
public void get() {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
        // 创建httpget.  
        HttpGet httpget = new HttpGet("http://www.baidu.com/");
        System.out.println("executing request " + httpget.getURI());
        // 执行get请求.  
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            // 获取响应实体  
            HttpEntity entity = response.getEntity();
            System.out.println("--------------------------------------");
            // 打印响应状态  
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容长度  
                System.out.println("Response content length: " + entity.getContentLength());
                // 打印响应内容  
                System.out.println("Response content: " + EntityUtils.toString(entity));
            }
            System.out.println("------------------------------------");
        } finally {
            response.close();
        }
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // 关闭连接,释放资源  
        try {
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*
	 * HttpClient Get请求带参数
	 */
	@Test
	public void fun1() throws ClientProtocolException, IOException {
		
//		1、创建httpClient
		CloseableHttpClient client = HttpClients.createDefault();
//		2、封装请求参数
		List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
		list.add(new BasicNameValuePair("username", "cgx"));
		list.add(new BasicNameValuePair("password", "123456"));
		
		//3、转化参数
		String params = EntityUtils.toString(new UrlEncodedFormEntity(list,Consts.UTF_8));
		System.out.println(params);
		//4、创建HttpGet请求
		HttpGet httpGet = new HttpGet("http://localhost:8080/itcast297/loginAction_login"+"?"+params);
		CloseableHttpResponse response = client.execute(httpGet);
		
		//5、获取实体
		HttpEntity entity = response.getEntity();
		//将实体装成字符串
		String string = EntityUtils.toString(entity);
		System.out.println(string);
		
		response.close();
	}

/**
 * 上传文件
 */
public void upload() {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
        HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceFile.action");

        FileBody bin = new FileBody(new File("F:\\image\\sendpix0.jpg"));
        StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);

        HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();

        httppost.setEntity(reqEntity);

        System.out.println("executing request " + httppost.getRequestLine());
        CloseableHttpResponse response = httpclient.execute(httppost);
        try {
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                System.out.println("Response content length: " + resEntity.getContentLength());
            }
            EntityUtils.consume(resEntity);
        } finally {
            response.close();
        }
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


log4j.properties配置
------------------------------------------------------------------------------------------------------------------------------

<dependency>
   <groupId>log4j</groupId>
   <artifactId>log4j</artifactId>
   <version>1.2.16</version>
</dependency>



 ### 配置根 ###
log4j.rootLogger = debug,console ,fileAppender,dailyRollingFile,ROLLING_FILE,MAIL,DATABASE

### 设置输出sql的级别，其中logger后面的内容全部为jar包中所包含的包名 ###
log4j.logger.org.apache=debug
log4j.logger.java.sql.Connection=debug
log4j.logger.java.sql.Statement=debug
log4j.logger.java.sql.PreparedStatement=debug
log4j.logger.java.sql.ResultSet=debug

### 配置输出到控制台 ###
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern =  %d{ABSOLUTE} %5p %c{ 1 }:%L - %m%n

### 配置输出到文件 ###
log4j.appender.fileAppender = org.apache.log4j.FileAppender
log4j.appender.fileAppender.File = logs/log.log
log4j.appender.fileAppender.Append = true
log4j.appender.fileAppender.Threshold = debug
log4j.appender.fileAppender.layout = org.apache.log4j.PatternLayout
log4j.appender.fileAppender.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

### 配置输出到文件，并且每天都创建一个文件 ###
log4j.appender.dailyRollingFile = org.apache.log4j.DailyRollingFileAppender
log4j.appender.dailyRollingFile.File = logs/log.log
log4j.appender.dailyRollingFile.Append = true
log4j.appender.dailyRollingFile.Threshold = debug
log4j.appender.dailyRollingFile.layout = org.apache.log4j.PatternLayout
log4j.appender.dailyRollingFile.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

### 配置输出到文件，且大小到达指定尺寸的时候产生一个新的文件 ###
log4j.appender.ROLLING_FILE=org.apache.log4j.RollingFileAppender 
log4j.appender.ROLLING_FILE.Threshold=ERROR 
log4j.appender.ROLLING_FILE.File=rolling.log 
log4j.appender.ROLLING_FILE.Append=true 
log4j.appender.ROLLING_FILE.MaxFileSize=10KB 
log4j.appender.ROLLING_FILE.MaxBackupIndex=1 
log4j.appender.ROLLING_FILE.layout=org.apache.log4j.PatternLayout 
log4j.appender.ROLLING_FILE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n

### 配置输出到邮件 ###
log4j.appender.MAIL=org.apache.log4j.net.SMTPAppender
log4j.appender.MAIL.Threshold=FATAL
log4j.appender.MAIL.BufferSize=10
log4j.appender.MAIL.From=chenyl@yeqiangwei.com
log4j.appender.MAIL.SMTPHost=mail.hollycrm.com
log4j.appender.MAIL.Subject=Log4J Message
log4j.appender.MAIL.To=chenyl@yeqiangwei.com
log4j.appender.MAIL.layout=org.apache.log4j.PatternLayout
log4j.appender.MAIL.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n

### 配置输出到数据库 ###
log4j.appender.DATABASE=org.apache.log4j.jdbc.JDBCAppender
log4j.appender.DATABASE.URL=jdbc:mysql://localhost:3306/test
log4j.appender.DATABASE.driver=com.mysql.jdbc.Driver
log4j.appender.DATABASE.user=root
log4j.appender.DATABASE.password=
log4j.appender.DATABASE.sql=INSERT INTO LOG4J (Message) VALUES ('[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n')
log4j.appender.DATABASE.layout=org.apache.log4j.PatternLayout
log4j.appender.DATABASE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n
log4j.appender.A1=org.apache.log4j.DailyRollingFileAppender
log4j.appender.A1.File=SampleMessages.log4j
log4j.appender.A1.DatePattern=yyyyMMdd-HH'.log4j'
log4j.appender.A1.layout=org.apache.log4j.xml.XMLLayout


















