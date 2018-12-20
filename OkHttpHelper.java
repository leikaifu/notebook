package youxuepai;

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
import java.util.concurrent.TimeUnit;

/**
 * OkHttpHelper.java
 *
 * @Group: youxuepai.com
 * @Author: leikaifu
 * @Date: 2018/12/20
 */
public class OkHttpHelper implements IHttpHelper {
      private final static String CHAR_SET = "utf-8";
      private final static int CONNECT_TIME_IN_SECOND = 60;
      private final static int WRITE_TIME_IN_SECOND = 60;
      private final static int READ_TIME_IN_SECOND = 60;
      public ConnectionPool connectionPool;
      private OkHttpClient httpClient;

      //构造函数,方法名必须和类名相等，并且有方法体
      public OkHttpHelper(){
        init();
      }
      //一般函数初始化httpclient
      public void init(){
        httpClient=new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .connectTimeout(CONNECT_TIME_IN_SECOND, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_IN_SECOND, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_IN_SECOND, TimeUnit.SECONDS)
                .cookieJar(new CookieJar() {
                  //增加cookie支持（保持session）
                  private HashMap<String, List<Cookie>> cookieMap = new HashMap<String, List<Cookie>>(1);
                  public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                      cookieMap.put(httpUrl.host(),list);
                  }
                  //加载新的cookies
                  public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                      List<Cookie>  list=cookieMap.get(httpUrl.host());
                    if (list == null) {
                      list = new ArrayList<Cookie>();
                    }
                    return list;
                   }
                })
                .build();
      }

      protected Request makeRequest(String url, Object param, RequestMethod method, Map<String, String> headers){
          Request.Builder builder=new Request.Builder();
          builder.url(url);
          Headers newHeaders=buildHeader(headers);
          if (newHeaders!=null){
              builder.headers(newHeaders);
          }
          switch (method){
              case GET:if (param!=null&&param instanceof String){

              }
          }
      }
      //URL拼接参数方法
    private String buildUrl(String url, String param){
          if (url!=null&&param!=null){
              StringBuilder sb=new StringBuilder(url);
              if (sb.indexOf("?")==-1){
                  sb.append("?");
              }else {
                  sb.append("&");
              }
              sb.append(param);
              return sb.toString();

          }
          return url;
    }
    //封装header头
    private Headers buildHeader(Map<String, String> headers){
          Headers.Builder builder=new Builder();
          if (!isEmpty(headers)){
              for (String keys:headers.keySet()){
                  builder.add(keys,headers.get(keys));
              }
              return builder.build();
          }
          return null;
    }
    public boolean isEmpty(Map map){
          return map==null||map.isEmpty();
      }
      public IResponse executeRequest(RequestParam param) {
        return null;
      }
      //响应结果
      public static class OkHttpResponse implements IResponse{
        private Response mResponse;
        private String mResonseText;
        private Exception mException;
        private long mContentLength = -1;

        public OkHttpResponse(Response mResponse) {
          this.mResponse = mResponse;
        }

        public Exception getmException() {
          return mException;
        }

        public void setmException(Exception msg) {
          this.mException = mException;
        }
        //响应状态
        public int status() {
          if (mResponse!=null){
            if (mException != null) {
              return -2;
            }
          }else{
            return mResponse.code();
          }
          return -1;
        }

        public String message() {
          if (mResponse==null){
            if (mException!=null){
                return mException.getMessage()==null?mException.getClass().getName()
                        :mException.getMessage();
            }
          }
          else {
            return mResponse.message();
          }
          return null;
        }

        public boolean isSuccessful() {
          return mResponse==null?false:mResponse.isSuccessful();
        }

        public long costTime() {
          return mResponse==null?-1
                  :mResponse.receivedResponseAtMillis()-mResponse.sentRequestAtMillis();
        }

        public long contentLength() {
            if (mResonseText == null) {
                return (mResponse == null || mResponse.body() == null) ? -1
                        : mResponse.body().contentLength();
            } else {
                return mContentLength;
            }
        }

        public InputStream inputStream() {
            if (mResponse!=null&&mResponse.body()!=null){
                return mResponse.body().byteStream();
            }
          return null;
        }

        public String parseAsString() {
            if (mResonseText==null){
                if (mResponse!=null&&mResponse.body()!=null){
                    try {
                        mResonseText=mResponse.body().string();
                        if (mResonseText != null && mContentLength == -1) {
                            mContentLength = mResonseText.getBytes().length;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
          return mResonseText;
        }

        public String header(String name) {
            if (mResponse!=null){
                return mResponse.header(name);
            }
          return null;
        }

        public Response getRawResponse() {
          return mResponse;
        }
      }
}

