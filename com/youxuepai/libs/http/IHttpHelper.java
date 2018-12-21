package com.youxuepai.libs.http;

import java.io.InputStream;
import java.util.Map;

/**
 * IHttpHelper.java
 *
 * @Group: youxuepai.com
 * @Author: leikaifu
 * @Date: 2018/12/20
 */
public interface IHttpHelper {
  //
  IResponse executeRequest(RequestParam param);

  //请求方法 3
  enum RequestMethod {
    GET,
    POST,
    PUT,
    DELETE
  }
  //1
  interface IResponse {
    //响应状态
    int status();
    //发送的消息
    String message();
    //响应是否200
    boolean isSuccessful();
    //请求到响应耗时长
    long costTime();
    //内容长度
    long contentLength();
    //流
    InputStream inputStream();
    //解析字符串
    String parseAsString();
    //header
    String header(String name);
  }
  //请求参数 2
  class RequestParam {
    private RequestMethod method;
    private String url;
    private Object param;
    private Map<String, String> headers;
    //四个参数都不为空时；
    public RequestParam(RequestMethod method, String url, Object param, Map<String, String> headers) {
      this.method = method;
      this.url = url;
      this.param = param;
      this.headers = headers;
    }
    //headers参数为空时；
    public RequestParam(RequestMethod method, String url, Object param) {
      this.method = method;
      this.url = url;
      this.param = param;
      this.headers = null;
    }
    //请求方法、headers两个参数为空时；
    public RequestParam( String url, Object param) {
      this.method = RequestMethod.GET;
      this.url = url;
      this.param = param;
      this.headers=null;
    }
    //参数只有URL时；
    public RequestParam(String url) {
      this.url = url;
      this.method=RequestMethod.GET;
      this.param = null;
      this.headers = null;
    }

    public RequestMethod getMethod() {
      return method;
    }

    public void setMethod(RequestMethod method) {
      this.method = method;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public Object getParam() {
      return param;
    }

    public void setParam(Object param) {
      this.param = param;
    }

    public Map<String, String> getHeaders() {
      return headers;
    }

    public void setHeaders(Map<String, String> headers) {
      this.headers = headers;
    }
  }

}

