package com.youxuepai.libs.http;

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
import java.util.jar.JarEntry;

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



    //封装请求头方法request  第一种类型  参数为Object param
      protected Request makeRequest(String url, Object param, RequestMethod method,
                                    Map<String, String> headers){
          Request.Builder builder=new Request.Builder();
          builder.url(url);
          Headers newHeaders=buildHeader(headers);
          if (newHeaders!=null){
              builder.headers(newHeaders);
          }
          switch (method){
              case GET:if (param!=null&&param instanceof String){
                    String newurl=buildUrl(url, (String) param);
                    builder.url(newurl);
              }
                    builder.get();
                    break;
              case POST:
                  builder.post(buildBody(param));
                  break;
              case PUT:
                  builder.put(buildBody(param));
                  break;
              case DELETE:
                  if (param == null) {
                      builder.delete();
                  } else {
                      builder.delete(buildBody(param));
                  }
                  break;
              default:
                  break;
          }
          return builder.build();
      }
    //  封装请求头方法request  第2种类型 参数为 Map<String,Object>params
    protected Request makeRequest(String url, Map<String,Object>params, RequestMethod method,Map<String, String> headers){
        Request.Builder builder=new Request.Builder();
        builder.url(url);
        Headers newHeaders = buildHeader(headers);
        if (newHeaders!=null){
            builder.headers(newHeaders);
        }switch (method){
            case GET:
                String newUrl = buildUrl(url,params);
                builder.url(newUrl);
                builder.get();
                break;
            case POST:
                builder.post(buildBody(params));
                break;
            case PUT:
                builder.put(buildBody(params));
                break;
            case DELETE:
                if (params == null) {
                    builder.delete();
                } else {
                    builder.delete(buildBody(params));
                }
                break;
            default:
                break;
        }
        return builder.build();

    }
    private RequestBody buildBody(Object param){
          if (param!=null){
              if (param instanceof JSONObject||param instanceof JSONArray){
                  String json=null;
                  if (param instanceof JSONObject) {
                      json = ((JSONObject) param).toJSONString();
                  } else {
                      json =((JSONArray) param).toJSONString();
                  }
                  return RequestBody.create(MediaType.parse("application/json"), json);
              }else if (param instanceof String){
                  return RequestBody.create(MediaType.parse("text/plain"), (String) param);
              }else if (param instanceof File){
                  File file= (File) param;
                  return RequestBody.create(parseMediaTypeByFileName(file), file);
              }
          }
          return null;
    }

    private RequestBody buildBody(Map<String, Object> params){
        if (!isEmpty(params)){
            if (isSimpleFormParam(params)){
                FormBody.Builder builder=new FormBody.Builder();
                for (Map.Entry<String,Object> entry:params.entrySet()){
                    builder.add(entry.getKey(),entry.getValue().toString());
                }
               return builder.build();
            }else {
                MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
                    for (Map.Entry<String,Object> entry:params.entrySet()){
                        Object data=entry.getValue();
                        if (isSupportMedia(data)){
                            addSupportMedia(builder,entry.getKey(),data);
                        }else {
                            builder.addFormDataPart(entry.getKey(),data.toString());
                        }
                    }
                    return builder.build();
            }

        }
        return null;
    }
    private MediaType parseMediaTypeByFileName(File file){
        String fileName=file.getName().toLowerCase();
        if (fileName.endsWith(".png")){
            return MediaType.parse("image/png");
        }else if (fileName.endsWith(".jpg")){
            return MediaType.parse("image/jpeg");
        }else if (fileName.endsWith(".bmp")){
            return MediaType.parse("application/x-bmp");
        }else if (fileName.endsWith(".gif")){
            return MediaType.parse("image/gif");
        }else if (fileName.endsWith(".mp3")){
            return MediaType.parse("audio/mp3");
        }else if (fileName.endsWith(".mp4")){
            return MediaType.parse("video/mpeg4");
        }
        return MediaType.parse("application/octet-stream");
    }

    private void addSupportMedia(MultipartBody.Builder builder, String name, Object object){
        if (object instanceof JSONObject||object instanceof JSONArray){
            String str= JSON.toJSONString(object);
            builder.addFormDataPart(name,str);
        }else if (object instanceof File){
            File file= (File) object;
            RequestBody fileBody=RequestBody.create(parseMediaTypeByFileName(file),file);
            builder.addFormDataPart(name,file.getName(),fileBody);

        }
    }

    private boolean isSupportMedia(Object object){
        if (object!=null){
            if (object instanceof JSONArray||object instanceof JSONObject|| object instanceof File){
                return true;
            }
        }
        return false;
    }

    private boolean isSimpleFormParam(Map<String, Object> params){
        if (!isEmpty(params)){
            for (Map.Entry<String,Object> entry:params.entrySet()){
                Object data=entry.getValue();
                if (isSupportMedia(data)){
                    return false;
                }
            }
        }
        return true;
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

    private String buildUrl(String url, Map<String,Object> params){
        if (url!=null&&!isEmpty(params)){
            StringBuilder sb=new StringBuilder(url);
            for (String key:params.keySet()){
                if (sb.indexOf("?")==-1){
                    sb.append("?");
                }else {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(params.get(key));
            }
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
    //类型1
    public OkHttpResponse executeRequest(String url, Map<String, Object> params) {
        return executeRequest(url, params, RequestMethod.GET);
    }
    //类型2
    public OkHttpResponse executeRequest(String url, Object param, RequestMethod method,
                                         Map<String, String> headers){
        Request request=makeRequest(url,param,method,headers);
        return executeRequest(request);
    }
    //类型3
    public OkHttpResponse executeRequest(String url) {
        return executeRequest(url,null);
    }

    //类型5
    public OkHttpResponse executeRequest(String url, Object param) {
        return executeRequest(url, param, RequestMethod.GET);
    }
    //类型6
    public OkHttpResponse executeRequest(String url, Object param, RequestMethod method) {
        return executeRequest(url, param, method, null);
    }
    //类型7
    public OkHttpResponse executeRequest(String url, Map<String, Object> params,
                                         RequestMethod method) {
        return executeRequest(url, params, method, null);
    }

    public IResponse executeRequest(RequestParam param){
          if (param.getParam()!=null&&param instanceof Map){
              return executeRequest(param.getUrl(), (Map<String, Object>) param.getParam(),param.getMethod(),param.getHeaders());
          }else {
              return executeRequest(param.getUrl(), param.getParam(),
                      param.getMethod(), param.getHeaders());

          }
    }



      //响应方法
      public OkHttpResponse executeRequest(Request request) {
        try {
            Response response=httpClient.newCall(request).execute();
            return new OkHttpResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
            OkHttpResponse res=new OkHttpResponse(null);
            res.setException(e);
            return res;
        }
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

        public Exception getException() {
          return mException;
        }

        public void setException(Exception msg) {
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

