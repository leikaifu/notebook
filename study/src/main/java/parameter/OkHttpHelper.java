package parameter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import okhttp3.Headers.Builder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * OkHttpHelper.java
 *
 * @Group: youxuepai.com
 * @Author: leikaifu
 * @Date: 2018/5/23
 */
public class OkHttpHelper  {

  private final static String CHAR_SET = "utf-8";
  private final static int CONNECT_TIME_IN_SECOND = 60;
  private final static int WRITE_TIME_IN_SECOND = 60;
  private final static int READ_TIME_IN_SECOND = 60;
  public ConnectionPool connectionPool;
  private OkHttpClient httpClient;

    public OkHttpHelper() {
        init();
    }

    private void init() {
    connectionPool = new ConnectionPool(1, 5L, TimeUnit.SECONDS);
    httpClient = new OkHttpClient.Builder()
        .connectionPool(connectionPool)
        .connectTimeout(CONNECT_TIME_IN_SECOND, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIME_IN_SECOND, TimeUnit.SECONDS)
        .readTimeout(READ_TIME_IN_SECOND, TimeUnit.SECONDS)
        .cookieJar(new CookieJar() {
          //增加cookie支持（保持session）
          private HashMap<String, List<Cookie>> cookieMap = new HashMap<String, List<Cookie>>(1);

          public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            cookieMap.put(httpUrl.host(), list);
          }

          public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> list = cookieMap.get(httpUrl.host());
            if (list == null) {
              list = new ArrayList<Cookie>();
            }
            return list;
          }
        })
        .build();
  }
}

