package parameter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.Reporter;

import java.util.Map;

/**
 * @author huang
 */
public class JsonChecker extends DefaultChecker {

  private String mResponse;
  private String mJsonTemplate;

  public JsonChecker(String response, String template) {
    this.mResponse = response;
    this.mJsonTemplate = template;
  }
  public boolean checkKey() {
    if (mResponse != null) {
      String msg = parseAndCheck(mResponse, mJsonTemplate, false);
      setPass(msg == null);
      setCheckMessage(msg == null ? "key match" : msg);
        if (msg==null){
          Reporter.log("测试通过");
        }else{
          Reporter.log("异常响应："+getCheckMessage());
        }
    } else {
      setPass(false);
      setCheckMessage("没有返回数据");
      Reporter.log("异常响应："+getCheckMessage());
    }
    return isPass();
  }

  public boolean checkKeyAndValue() {
    if (mResponse != null) {
      String msg = parseAndCheck(mResponse, mJsonTemplate, true);
      setPass(msg == null);
      //如果msg等于空时为true；
      setCheckMessage(msg == null ? "key and value match" : msg);
        if (msg==null){
          Reporter.log("测试通过");
        }else{
          Reporter.log("异常响应："+getCheckMessage());
        }
    } else {
      setPass(false);
      setCheckMessage("没有返回数据");
      Reporter.log("异常响应："+getCheckMessage());
    }
    return isPass();
  }

  private String parseAndCheck(String a, String b, boolean checkValue) {
    if (StringUtils.isEmpty(a)) {
      return "没有返回数据";
    } else if (StringUtils.isEmpty(b)) {
      return "没有模板";
    } else {
      try {
        if (b.startsWith("[")) {
          JSONArray arrayA = JSON.parseArray(a);
          JSONArray arrayB = JSON.parseArray(b);
          return checkObjectMatch(arrayA, arrayB, checkValue);
        } else {
          JSONObject jsonA = JSON.parseObject(a);
          JSONObject jsonB = JSON.parseObject(b);
          return checkObjectMatch(jsonA, jsonB, checkValue);
        }
      } catch (Exception e) {
        return "process error:" + e.getMessage();
      }
    }
  }

  private String checkObjectMatch(Object a, Object b, boolean checkValue) {
    try {
      if (b != null) {
        if (a == null) {
          return "返回数据中缺少模板中期望值为:" + b + "的匹配内容";
        }
        if (b instanceof JSONArray) {
          for (int i = 0; i < ((JSONArray) b).size(); i++) {
            String r = checkObjectMatch(((JSONArray) a).get(i), ((JSONArray) b).get(i), checkValue);
            if (r != null) {
              return r;
            }
          }
        } else if (b instanceof JSONObject) {
          for (Map.Entry<String, Object> entry : ((JSONObject) b).entrySet()) {
            String r = checkObjectMatch(((JSONObject) a).get(entry.getKey()), entry.getValue(),
                checkValue);
            if (r != null) {
              return r;
            }
          }
        } else {
          if (b.getClass() != a.getClass()) {
            return "类型不匹配:" + a + " 实际类型是:" + a.getClass() + ",期望类型是:" + b
                .getClass();
          }
          if (checkValue) {
            if (!b.equals(a)) {
              return "Json值不正确，实际值是:" + a + ",期望值是:" + b;
            }
          }
        }
      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return "检查对象发生异常:" + e.getMessage();
    }
  }

  @Override
  public String responseText() {
    return mResponse;
  }

  @Override
  public long readResponseLength() {
    return mResponse == null ? 0 : mResponse.getBytes().length;
  }
}
