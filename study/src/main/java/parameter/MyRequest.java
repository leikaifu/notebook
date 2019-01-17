package parameter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MyRequest {
    //实例变量
    public String file;
    //构造函数
    public MyRequest(String file) {
        this.file = file;
    }
    //无参构造函数
    public MyRequest() {

    }

    //请求参数对象，使用list存储多个RequestParam；
    public List<RequestParam> requestParamlist() throws IOException, InvalidFormatException {
        ExcelReader read= new ExcelReader().read(new File(file));
        //从excle表中读取每行的数据；
        List<Map<String,Object>> mapList= read.toMaplist();
        if (!CollectionUtils.isEmpty(mapList)){
            List<RequestParam> requestParamList=new ArrayList<RequestParam>();
            for (int n=0;n<mapList.size();n++){
                RequestParam para=new RequestParam();
                Map<String,Object> map = (HashMap<String, Object>) mapList.get(n);
                para.setUrl(this.getExcelString(map.get("url")));
                para.setMethod(this.getExcelString(map.get("method")));
                para.setParam(this.getExcelString( map.get("params")));
                para.setCheck_template(this.getExcelString(map.get("check_template")));
                requestParamList.add(n,para);
            }
            return requestParamList;
        }
        return null;
    }

    public List<Request> request() throws IOException, InvalidFormatException {
        List<RequestParam> requestParamList=this.requestParamlist();
        MyRequest myRequest=new MyRequest();
        List<Request> requestList=new LinkedList<Request>();
        for (int m=0;m<requestParamList.size();m++){
            Request request= myRequest.makeRequest(requestParamList.get(m).getUrl(),requestParamList.get(m).getParam(), RequestMethod.valueOf((String)requestParamList.get(m).getMethod()));
            requestList.add(request);

        }
        return requestList;
    }

    protected Request makeRequest(String url, Object param, RequestMethod method) {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.header("key","6e224");
        switch (method) {
            case GET:
                if (param != null && param instanceof String) {
                    String newUrl = buildUrl(url, (String) param);
                    builder.url(newUrl);
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

    protected Request makeRequest(String url, Map<String, Object> params, RequestMethod method) {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.header("key","6e");
        switch (method) {
            case GET:
                String newUrl = buildUrl(url, params);
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
                if (params== null) {
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

    private String buildUrl(String url, Map<String, Object> params) {
        if (url != null && !isEmpty(params)) {
            StringBuilder sb = new StringBuilder(url);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (sb.indexOf("?") == -1) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return url;
    }

    private String buildUrl(String url, String param) {
        if (url != null && param != null) {
            StringBuilder sb = new StringBuilder(url);
            if (sb.indexOf("?") == -1) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append(param);
            return sb.toString();
        }
        return url;
    }

    private RequestBody buildBody(Map<String, Object> params) {
        if (!isEmpty(params)) {
            if (isSimpleFormParam(params)) {
                FormBody.Builder builder = new FormBody.Builder();
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    builder.add(entry.getKey(), entry.getValue().toString());
                }
                return builder.build();
            } else {
                MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    Object data = entry.getValue();
                    if (isSupportMedia(data)) {
                        addSupportMedia(builder, entry.getKey(), data);
                    } else {
                        builder.addFormDataPart(entry.getKey(), data.toString());
                    }

                }
                return builder.build();
            }
        }
        return null;
    }

    private RequestBody buildBody(Object param) {
        if (param != null) {
            if (param instanceof JSONObject || param instanceof JSONArray) {
                String json = null;
                if (param instanceof JSONObject) {
                    json = ((JSONObject) param).toJSONString();
                } else {
                    json = ((JSONArray) param).toJSONString();
                }
                return RequestBody.create(MediaType.parse("application/json"), json);
            } else if (param instanceof String) {
                return RequestBody.create(MediaType.parse("text/plain"), (String) param);
            } else if (param instanceof File) {
                File file = (File) param;
                return RequestBody.create(parseMediaTypeByFileName(file), file);
            }
        }
        return null;
    }

    private boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    private void addSupportMedia(MultipartBody.Builder builder, String name, Object object) {
        if (object instanceof JSONObject
                || object instanceof JSONArray) {
            String str = JSON.toJSONString(object);
            builder.addFormDataPart(name, str);
        } else if (object instanceof File) {
            File file = (File) object;
            RequestBody fileBody = RequestBody.create(parseMediaTypeByFileName(file), file);
            builder.addFormDataPart(name, file.getName(), fileBody);
        }
    }

    private MediaType parseMediaTypeByFileName(File file) {
        String fileName = file.getName().toLowerCase();
        if (fileName.endsWith(".png")) {
            return MediaType.parse("image/png");
        } else if (fileName.endsWith(".jpg")) {
            return MediaType.parse("image/jpeg");
        } else if (fileName.endsWith(".bmp")) {
            return MediaType.parse("application/x-bmp");
        } else if (fileName.endsWith(".gif")) {
            return MediaType.parse("image/gif");
        } else if (fileName.endsWith(".mp3")) {
            return MediaType.parse("audio/mp3");
        } else if (fileName.endsWith(".mp4")) {
            return MediaType.parse("video/mpeg4");
        }
        return MediaType.parse("application/octet-stream");
    }

    private boolean isSupportMedia(Object object) {
        if (object != null) {
            if (object instanceof JSONObject
                    || object instanceof JSONArray
                    || object instanceof File) {
                return true;
            }
        }
        return false;
    }

    private boolean isSimpleFormParam(Map<String, Object> params) {
        if (!isEmpty(params)) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                Object data = entry.getValue();
                if (isSupportMedia(data)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getExcelString(Object obj) {
        return obj == null ? null : obj.toString();
    }

}
